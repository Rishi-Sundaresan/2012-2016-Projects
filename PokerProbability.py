print("For inputting cards, types the number or letter of the card [1,2,3....10,J,Q,K,A] followed by an h for hearts, d for diamond, s for spades, and c for clubs. Make sure you do not repeat cards. To type a list of cards, separate cards with spaces")
import random
dec = ["As","2s","3s","4s","5s","6s","7s","8s","9s","10s","Js","Qs","Ks","Ac","2c","3c","4c","5c","6c","7c","8c","9c","10c","Jc","Qc","Kc","Ad","2d","3d","4d","5d","6d","7d","8d","9d","10d","Jd","Qd","Kd","Ah","2h","3h","4h","5h","6h","7h","8h","9h","10h","Jh","Qh","Kh"]

#Variables
MyCard1 = ""
MyCard2 = ""
MyCards = []
numberP = 0
ui = ""
Question = str(input("Are you in a round and would like to recieve probabilities starting from the first round of betting? Type Yes if yes, or if you just want to input any scenario, type No: "))
if not Question == "Yes":                    
    Mycard1 = str(input("Enter Card 1 here: "))
    Mycard2 = str(input("Enter Card 2 here: "))
    while Mycard1 == Mycard2:
        Mycard2 = str(input("Card Error. Please input Card 2 again: "))
    while not(len(Mycard1) < 4 and len(Mycard2) < 4):
        print("Card Error. Please Retry: ")
        Mycard1 = str(input("Enter Card 1 here: "))
        Mycard2 = str(input("Enter Card 2 here: "))
    ui = input("What are the cards on the table: ")
    numberP = int(input("How many other players are playing?: "))
    Mycards = [Mycard1, Mycard2]
def Pokergame():
    ##PointValue Function
        tablecards = ui
        deck = dec[:]
        import re
        def pointValue(x):
            
            TotalME = x + tablecards
            MyPlist = []
            for k in TotalME:
                d = list(k)
                MyPlist = MyPlist + d
            for k in MyPlist:
                if k == "0":
                    n = MyPlist.index(k)
                    MyPlist[n-1] = "10"
                    MyPlist.remove(k)
            L = []
            for k in MyPlist:
                if k.isalpha() == True:
                    L.append(k)
            from collections import Counter
            a = str(Counter(L))
            Za = a
            if "5" in a or "6" in a or "7" in a:
                Flush = True
            else:
                Flush = False
            cre = TotalME
            for k in MyPlist:
                if k in "sdch":
                    MyPlist.remove(k)
            for k in range(0, len(MyPlist)):
                if MyPlist[k] == 'J':
                    MyPlist[k] = '11'
                if MyPlist[k] == 'Q':
                    MyPlist[k] = '12'
                if MyPlist[k] == 'K':
                    MyPlist[k] = '13'
                if MyPlist[k] == 'A':
                    MyPlist[k] = '14'
            points = []
            bye = MyPlist
            A = []
            x = MyPlist
            
            
            for k in MyPlist:
                A.append(int(k))
            
            
            A.sort()
            
            x = []
            for k in A:
                x.append(str(k))
            x = str(''.join(x))
            
            con = 0
            for k in A:
                c = A.index(k)
                con += int(k)*(15**(c - len(A)+ 1))
            
            seeker = re.compile("([1][0]).*[1][1].*[1][2].*[1][3].*[1][4]")
            
            g = Za[10]
            
            I = []
            for k in cre:
                if str(g) in k:
                    I.append(k)
            
            sx = []
            for k in I:
                j = len(k) - 1
                p = str(k)
                v = p[:j]
                d = v.split()
                sx += d
            QUE = []
            
            
            for k in range(0,len(sx)):
                if sx[k] == 'J':
                    sx[k] = '11'
                if sx[k] == 'Q':
                    sx[k] = '12'
                if sx[k] == 'K':
                    sx[k] = '13'
                if sx[k] == 'A':
                    sx[k] = '14'
            for k in range(0, len(sx)):
                r = int(sx[k])
                QUE.append(r)
            QUE.sort()
            QU = []
            for k in QUE:
                QU.append(str(k))
            QU = str(''.join(QU))    
            
        
        
            ##Flush Straight
            if Flush == True and bool(seeker.search(QU)) == True:
                return 1000
            seeker = re.compile("[9].*[1][0].*11.*12.*13")
            if Flush == True and bool(seeker.search(QU)) == True:
                return 999
            seeker = re.compile("[8].*[9].*10.*11.*12")
            if Flush == True and bool(seeker.search(QU)) == True:
                return 998
            seeker = re.compile("[7].*[8].*[9].*10.*11")
            if Flush == True and bool(seeker.search(QU)) == True:
                return 997
            seeker = re.compile("[6].*[7].*[8].*[9].*10")
            if Flush == True and bool(seeker.search(QU)) == True:
                return 996
            seeker = re.compile("[5].*[6].*[7].*[8].*[9]")
            if Flush == True and bool(seeker.search(QU)) == True:
                return 995
            seeker = re.compile("[4].*[5].*[6].*[7].*[8]")
            if Flush == True and bool(seeker.search(QU)) == True:
                return 994
            seeker = re.compile("[3].*[4].*[5].*[6].*[7]")
            if Flush == True and bool(seeker.search(QU)) == True:
                return 993
            seeker = re.compile("[2].*[3].*[4].*[5].*[6]")
            if Flush == True and bool(seeker.search(QU)) == True:
                return 992
            seeker = re.compile("[2].*[3].*[4].*[5].*14")
            if Flush == True and bool(seeker.search(QU)) == True:
                return 991
            
            ##Four of a Kind
            seeker = re.compile("[1][4][1][4][1][4][1][4]")
            if bool(seeker.search(x)) == True:
                return 990
            if bool((re.compile("[1][3][1][3][1][3][1][3]")).search(x)) == True:
                return 989
            if bool((re.compile("[1][2][1][2][1][2][1][2]")).search(x)) == True:
                return 988
            if bool((re.compile("[1]{8}")).search(x)) == True:
                return 987
            if bool((re.compile("[1][0][1][0][1][0][1][0]")).search(x)) == True:
                return 986
            if bool((re.compile("[9]{4}")).search(x)) == True:
                return 985
            if bool((re.compile("[8]{4}")).search(x)) == True:
                return 984
            if bool((re.compile("[7]{4}")).search(x)) == True:
                return 983
            if bool((re.compile("[6]{4}")).search(x)) == True:
                return 982
            if bool((re.compile("[5]{4}")).search(x)) == True:
                return 981
            if bool((re.compile("[4]{4}")).search(x)) == True:
                return 980
            if bool((re.compile("[3]{4}")).search(x)) == True:
                return 979
            if bool((re.compile("[2]{4}")).search(x)) == True:
                return 978
            
            ##Full House
            for y in range(15, 1, -1):
                if y <= 9:
                    if bool((re.compile("%s{3}" % y)).search(x)) == True:
                        for z in range(14,1,-1):
                            if z > 9:
                                u = z - 10
                                if bool((re.compile("([1]%s){2}" % u)).search(x)) == True and not z == y:
                                    return 15*y + z + 750
                            if z <=9:
                                if bool((re.compile("%s{2}" % z)).search(x)) == True and not z == y:
                                    return 15*y + z + 750
                else:
                    t = y - 10
                    if bool((re.compile("([1]%s){3}" % t)).search(x)) == True:
                        for z in range(14, 1, -1):
                            if z > 9:
                                u = z - 10
                                if bool((re.compile("([1]%s){2}" % u)).search(x)) == True and not z == y:
                                    return 15*y + z + 750
                            if z <= 9:
                                if bool((re.compile("%s{2}" % z)).search(x)) == True and not z == y:
                                    return 15*y + z + 750
            
            ##Flush
            if Flush == True:
                    return con + 700
        
          
            
            ##Straight
            if bool((re.compile("[1][0].*[1][1].*[1][2].*[1][3].*[1][4]")).search(x)) == True:
                return 699
            if bool((re.compile("[9].*[1][0].*[1][1].*[1][2].*[1][3]")).search(x)) == True:
                return 698
            if bool((re.compile("[8].*[9].*[1][0].*[1][1].*[1][2]")).search(x)) == True:
                return 697
            if bool((re.compile("[7].*[8].*[9].*[1][0].*[1][1]")).search(x)) == True:
                return 696
            if bool((re.compile("[6].*[7].*[8].*[9].*[1][0]")).search(x)) == True:
                return 695
            if bool((re.compile("[5].*[6].*[7].*[8].*[9]")).search(x)) == True:
                return 694
            if bool((re.compile("[4].*[5].*[6].*[7].*[8]")).search(x)) == True:
                return 693
            if bool((re.compile("[3].*[4].*[5].*[6].*[7]")).search(x)) == True:
                return 692
            if bool((re.compile("[2].*[3].*[4].*[5].*[6]")).search(x)) == True:
                return 691
            if bool((re.compile("[2].*[3].*[4].*[5].*14")).search(x)) == True:
                return 690
        
            ##Three of a kind
            for y in range(15, 1, -1):
                if y < 10:
                    if bool((re.compile("%s{3}" % y)).search(x)) == True:
                        return y + 670
                if y >= 10:
                    a = y - 10
                    if bool((re.compile("([1]%s){3}" % a)).search(x)) == True:
                        return y + 670
                
            
            ##Two Pair
        
            for y in range(15, 1, -1):
                if y <= 9:
                    if bool((re.compile("%s{2}" % y)).search(x)) == True:
                        for z in range(14,1,-1):
                            if z > 9:
                                u = z - 10
                                if bool((re.compile("([1]%s){2}" % u)).search(x)) == True and bool(z == y) == False:
                                    return 15*y + z + 400
                            if z <=9:
                                if bool((re.compile("%s{2}" % z)).search(x)) == True and bool(z == y) == False:
                                    return 15*y + z + 400
                else:
                    t = y - 10
                    if bool((re.compile("([1]%s){2}" % t)).search(x)) == True:
                        for z in range(14, 1, -1):
                            if z > 9:
                                u = z - 10
                                if bool((re.compile("([1]%s){2}" % u)).search(x)) == True and bool(z == y) == False:
                                    return 15*y + z + 400
                            if z <= 9:
                                if bool((re.compile("%s{2}" % z)).search(x)) == True and not z == y:
                                    return 15*y + z + 400
            
            
            
            #One Pair
        
            for y in range(15, 1, -1):
                if y < 10:
                        if bool((re.compile("%s{2}" % y)).search(x)) == True:
                                return y + 380
                if y >= 10:
                        a = y - 10
                        if bool((re.compile("([1]%s){2}" % a)).search(x)) == True:
                                return y + 380
        
        
            #High Card
            return con
        ##MY CARDS
        Mycards = [Mycard1, Mycard2] 
        for k in deck:
            if k in Mycards:
                deck.remove(k)
        for k in deck:
            if k in Mycards:
                deck.remove(k)
        
        ##CARDS ON TABLE
        x = tablecards.split()
        
        yu = 5 - len(tablecards)
        for k in deck:
            if k in tablecards:
                deck.remove(k)
        
        othertablecards = random.sample(deck, int(2))
        
        
        
        tablecards = x + othertablecards
        for card in deck:
            if card in tablecards:
                deck.remove(card)
        
        
        
        ##OTHER PLAYER'S CARDS
            
        listopponentcards = random.sample(deck, 2*numberP)
        
        for card in deck:
            if card in listopponentcards:
                deck.remove(card)
        
        ##Sanitiz
        
        Places = []
        Places.append(pointValue(Mycards))
        
        for k in range(0, int(len(listopponentcards)/2)):
            d = (listopponentcards[2*k]).split() + (listopponentcards[2*k+1]).split()
            
            Places.append(pointValue(d))
        
        
        b = max(Places)
        n = Places.index(b)
        return(n)

def probability():
    print("")
    print("Calculating Probability of Winning...")
    c = 0
    w = 5000
    for k in range(0, w):
        if str(Pokergame()) =="0":
            c+=1
    print("")
    print("Probability of Winning: " + str((c/w)*100) + " Percent")


if not Question == "Yes":
    probability()
#!/usr/bin/env python3
if Question == "Yes":
    print("Stage 1")
    Mycard1 = str(input("Enter Card 1 here: "))
    Mycard2 = str(input("Enter Card 2 here: "))
    while Mycard1 == Mycard2:
        Mycard2 = str(input("Card Error. Please input Card 2 again: "))
    while not(len(Mycard1) < 4 and len(Mycard2) < 4):
            print("Card Error. Please Retry: ")
            Mycard1 = str(input("Enter Card 1 here: "))
            Mycard2 = str(input("Enter Card 2 here: "))
    numberP = int(input("How many other players are playing?: "))
    ui = ""
    probability()
    print("")
    print("Stage 2")
    ui = input("What are the cards on the table: ")
    probability()
    print("")
    print("Stage 3")
    ui = ui + " " + input(("What is the next card: "))
    probability()
    print("Stage 4")
    ui = ui + " " + input(("What is the river (last card): "))
    probability()
    

