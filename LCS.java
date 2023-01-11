/* Name: Endrit Basha
 * Dr. Andrew Steinberg
 * COP3503 Fall 2022
 * Programming Assignment 4
 */
public class LCS {
    //class attributes
    private String seqX;
    private String seqY;
    private char seqXArr[];
    private char seqYArr[];
    private int LCS[][];
    private char printLCS[][];



    public LCS (String seqX, String seqY){
        this.seqX = seqX;
        this.seqY = seqY;
        //taking the 2 strings and putting them into 2 arrays.
        seqXArr = seqX.toCharArray();
        seqYArr = seqY.toCharArray();
        //creating a 2d table to do memoization
        LCS = new int[seqX.length()+1][seqY.length()+1];
        //creating another 2d table to input the arrows for our print function
        printLCS = new char[seqX.length()+1][seqY.length()+1];
    }

    //DP Algorithm
    public void lcsDynamicSol()
    {
        int i = 0;
        int j = 0;
        //iterating thru all the rows
        for (i=1; i<=seqX.length(); i++)
        {
            //iterating thru all the columns
            for(j=1 ; j<=seqY.length(); j++)
            {
                //case 1 -> if it matches, take the result from what we have diagonally and add 1
                if(seqXArr[i-1] == seqYArr[j-1]){
                    LCS[i][j] = LCS[i-1][j-1] + 1;
                    //'d' for diagonal arrow
                    printLCS[i][j] = 'd';
                }
                //case 2 if it doesnt match then we check if the result above is bigger then the result in the left
                else if(LCS[i-1][j] >= LCS[i][j-1]){
                    //if so, we store the same result in current index.
                    LCS[i][j] = LCS[i-1][j];
                    printLCS[i][j] = 'u';
                }
                else{
                    //case 3 if it doesnt match then we check if the result in the left is bigger then the result above
                    LCS[i][j] = LCS[i][j-1];
                    printLCS[i][j] = 'l';
                }
            }
        }
    }

    //function to return the longest common subsequence
    public String getLCS(){
        String sequence = "";
        int lengthX = seqX.length();
        int lengthY = seqY.length();
        while(lengthX > 0 && lengthY > 0)
        {
            if(printLCS[lengthX][lengthY] == 'd'){
                lengthX--;
                lengthY--;
                sequence = seqXArr[lengthX] + sequence ;
            }
            else if(printLCS[lengthX][lengthY] == 'u'){
                lengthX--;
            }
            else{
                lengthY--;
            }
        }
        return sequence;

    }
}
