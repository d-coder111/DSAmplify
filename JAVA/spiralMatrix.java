import java.util.*;
class spiralMatrix
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
System.out.println("Enter the  rows");
int rows = sc.nextInt();
System.out.println("Enter the coloumns");
int col = sc.nextInt();
int arr[][]=new int [rows][col];
System.out.println("Enter the elements in matrix");
for(int i=0;i<rows;i++)
{

    for(int j= 0;j<col;j++)
    arr[i][j]=sc.nextInt();
}
System.out.println(spiralOrder(arr));
sc.close();
    }
    public static  List<Integer>spiralOrder(int[][] matrix)
    {
        int numrows = matrix.length;
        int numcol = matrix[0].length;
        boolean[][] seen = new boolean[numrows][numcol];
        ArrayList<Integer> List = new ArrayList<Integer>(numrows*numcol);
        if(matrix.length==0)
        return List;
        int[] dr = {0,1,0,-1};
        int[] dc = {1,0,-1,0};
        int x= 0 , y=0,di=0;
        for(int i=0;i<numrows*numcol;i++)
        {
            List.add(matrix[x][y]);
            seen[x][y]=true;
            int cr = x+dr[di];
            int cc = y+dc[di];
            if(0<=cr &&  cr<numrows && 0<=cc && cc<numcol && !seen[cr][cc])
            {
            x=cr;
            y=cc;
        }
        else{
            di = (di+1)%4;
            x+=dr[di];
            y+=dc[di];
        }
        }
        return List;
        
    }
}