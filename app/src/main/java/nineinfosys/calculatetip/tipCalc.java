package nineinfosys.calculatetip;

public class tipCalc
{
    static double bill;
    double tip;
    double totaltip;
    double split;
    double splitPrompt;
    double Y;
    double N;
    double billPerPerson;

     /*   static Scanner scan = new Scanner(System.in);*/
        public static double calBill(double bill)
        {
             /*bill = scan.nextDouble();
            return 0;*/
            return  bill;
        }

        public double percTip(double bill,double tip)
        {
           /* tip = scan.nextDouble();*/
            if(tip<1)
            {
                totaltip = bill * tip;
            }
        else totaltip = bill * (tip/100);
            
       /* System.out.println("Your total is: " + totaltip);*/
        Split( totaltip,split);
            return totaltip;
        }


        public double Split(double totaltip,double split)
        {
     /*   System.out.println("Would you like to split the bill? ");
        System.out.println("Enter 1 for YES or 0 for NO: ");*/

     /* splitPrompt = scan.nextDouble();*/
        
     /*   if(splitPrompt == 0) {

          //  System.out.println("Your total tip is: " + totaltip);
          *//*  System.out.println("Thankyou. Goodbye.");*//*
        	}
        	else*/ //if(splitPrompt == 1) {
        	/*	System.out.println("How many ways would you like to split the bill?");*/
        				/*split = scan.nextDouble();*/
                  billPerPerson = (totaltip / split);
                /*  System.out.println("Each person pays: " + billPerPerson);
                  System.out.println("Total Bill is:"+(totaltip+bill));*/
        //	}
        	/*else {
        		System.out.println("Invalid Entry");
        	}*/
            return billPerPerson;
        }
    }