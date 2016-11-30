from __future__ import division
import sys
import os.path
import numpy as np
import math
import util

USAGE = "%s <test data folder> <spam folder> <ham folder>"
global counter
def get_counts(file_list):
    """
    Computes counts for each word that occurs in the files in file_list.

    Inputs
    ------
    file_list : a list of filenames, suitable for use with open() or 
                util.get_words_in_file()

    Output
    ------
    A dict whose keys are words, and whose values are the number of files the
    key occurred in.
    """
    ### TODO: Comment out the following line and write your code here
    #raise NotImplementedError
    dictionary = util.DefaultDict(lambda: 0)
    for filename in file_list:
        list_of_words = set(util.get_words_in_file(filename))
        for word in list_of_words:
                dictionary[word] += 1
    return dictionary



def get_log_probabilities(file_list):
    """
    Computes log-frequencies for each word that occurs in the files in 
    file_list.

    Input
    -----
    file_list : a list of filenames, suitable for use with open() or 
                util.get_words_in_file()

    Output
    ------
    A dict whose keys are words, and whose values are the log of the smoothed
    estimate of the fraction of files the key occurred in.

    Hint
    ----
    The data structure util.DefaultDict will be useful to you here, as will the
    get_counts() helper above.
    """
    ### TODO: Comment out the following line and write your code here
    ### raise NotImplementedError
    file_list_length = len(file_list)
    count_dictionary = get_counts(file_list) ##Gets how many files each word in vocabulary occurs in.
    out_dictionary = util.DefaultDict(lambda: (np.log(1.0/(2.0+file_list_length)))) ##Dictionary containing parameter values, 
    ###default value log(1/2)/(# of total files)

    for word,frequency in count_dictionary.items():
        ### get parameters for each word: 
        ### each parameter = log((no. of files word is in + 1)/ (total files in list + 2))
        out_dictionary[word] = np.log(float(count_dictionary[word] + 1.0)/float(file_list_length + 2.0))
    return out_dictionary





def learn_distributions(file_lists_by_category):
    """
    Input
    -----
    A two-element list. The first element is a list of spam files, 
    and the second element is a list of ham (non-spam) files.

    Output
    ------
    (log_probabilities_by_category, log_prior)

    log_probabilities_by_category : A list whose first element is a smoothed
                                    estimate for log P(y=w_j|c=spam) (as a dict,
                                    just as in get_log_probabilities above), and
                                    whose second element is the same for c=ham.

    log_prior_by_category : A list of estimates for the log-probabilities for
                            each class:
                            [est. for log P(c=spam), est. for log P(c=ham)]
    """
    ### TODO: Comment out the following line and write your code here
    spam_emails = file_lists_by_category[0]
    ham_emails = file_lists_by_category[1]

    ###Learns parameters for each word for each category of emails
    log_probabilities_by_category = [get_log_probabilities(spam_emails), 
    get_log_probabilities(ham_emails)]

    ### s = (no. of spam emails)/ (no. of total emails)
    ### 1 - s = (no. of ham emails)/ (no. of total emails)
    total_emails = len(spam_emails) + len(ham_emails)
    s_spam = np.log(len(spam_emails)/total_emails)
    s_ham = np.log(len(ham_emails)/total_emails)
    log_prior = [s_spam, s_ham]

    ##Playing with log prior
    #q = 0.71
    #log_prior = [np.log(q), np.log(1-q)]
    return (log_probabilities_by_category, log_prior)


def classify_message(message_filename,
                     log_probabilities_by_category,
                     log_prior_by_category,
                     names = ['spam', 'ham']):
    """
    Uses Naive Bayes classification to classify the message in the given file.

    Inputs
    ------
    message_filename : name of the file containing the message to be classified

    log_probabilities_by_category : See output of learn_distributions

    log_prior_by_category : See output of learn_distributions

    names : labels for each class (for this problem set, will always be just 
            spam and ham).

    Output
    ------
    One of the labels in names.
    """
    ### TODO: Comment out the following line and write your code here
    comparison_list = [None]*2
    ##First find probability that c = spam, then of c = ham
    counter1 = 0
    dictionary1 = log_probabilities_by_category[0]
    vocabulary = set(log_probabilities_by_category[0].keys() + log_probabilities_by_category[1].keys())
    for i in range(0,2):
        log_sum_part = 0
        word_list = util.get_words_in_file(message_filename)
        ## Compare numerators of probabilities, which is a log_sum plus log_prior
        ## for each word in the vocabulary:
        ## add parameter to sum if word in file, or
        ## add log(1-exp(parameter)) if word not in files
        for word in vocabulary:
            if word in word_list:
                log_sum_part += log_probabilities_by_category[i][word]
            else:
                log_sum_part += np.log(1.0 - math.exp(log_probabilities_by_category[i][word]))
        ## append each log_sum + log_prior to comparison list to compare, and pick higher sum
        ##0th index is probability that it is spam, 1st index is P(ham)
        comparison_list[i] = log_prior_by_category[i] + log_sum_part
    if comparison_list[0] >= comparison_list[1]:
        return 'spam'
    else:
        return 'ham'
    

if __name__ == '__main__':
    ### Read arguments
    if len(sys.argv) != 4:
        print(USAGE % sys.argv[0])
    testing_folder = sys.argv[1]
    (spam_folder, ham_folder) = sys.argv[2:4]

    ### Learn the distributions
    print("Learning Parameters...")
    file_lists = []
    for folder in (spam_folder, ham_folder):
        file_lists.append(util.get_files_in_folder(folder))
    (log_probabilities_by_category, log_priors_by_category) = \
            learn_distributions(file_lists)
    print("Parameters determined")

    # Here, columns and rows are indexed by 0 = 'spam' and 1 = 'ham'
    # rows correspond to true label, columns correspond to guessed label
    performance_measures = np.zeros([2,2])

    counter = 0
    length = len(util.get_files_in_folder(testing_folder))
    ### Classify and measure performance
    for filename in (util.get_files_in_folder(testing_folder)):
        ## Classify
        label = classify_message(filename,
                                 log_probabilities_by_category,
                                 log_priors_by_category,
                                 ['spam', 'ham'])
        counter += 1
        if counter % 5 == 0:
            out_message = "%d messages classified out of " + str(length)
            print(out_message % counter)

        ## Measure performance
        # Use the filename to determine the true label
        base = os.path.basename(filename)
        true_index = ('ham' in base)
        guessed_index = (label == 'ham')
        performance_measures[true_index, guessed_index] += 1


        # Uncomment this line to see which files your classifier
        # gets right/wrong:
        #print("%s : %s" %(label, filename))

    template="You correctly classified %d out of %d spam messages, and %d out of %d ham messages."
    # Correct counts are on the diagonal
    correct = np.diag(performance_measures)
    # totals are obtained by summing across guessed labels
    totals = np.sum(performance_measures, 1)
    print(template % (correct[0],
                      totals[0],
                      correct[1],
                      totals[1]))

