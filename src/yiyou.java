
public class yiyou {


    public static  void main(String[] args){
        int[] s ={0,1,0,2,0,0,2,1,0};
        for(int i=0;i<9;i++){
              if(connect(i,s)==true&&s[i]!=0){
                  System.out.println(s[i]+"号选手胜利");
                  return;
              }
        }
        for(int i =0;i<9;i++){
            if(s[i]==0) {
                System.out.println("游戏继续");
                return;
            }
        }
        System.out.println("游戏结束，平局");
        return;
    }
    public static boolean connect(int i,int[] ints){
        boolean result = false;
        int iresult = -1;
        if(i == 1||i==7||i==4){
            if(ints[i]==ints[i-1]&&ints[i]==ints[i+1]){
                iresult = i;
                result = true;
            }
        }
        if(i==3||i==5||i==4){
            if(ints[i]==ints[i-3]&&ints[i]==ints[i+3]){
                iresult = i;
                result = true;
            }

        }
        if(i==4){
            if((ints[4]==ints[2]&&ints[4]==ints[6])||(ints[4]==ints[0]&&ints[4]==ints[8])){
                iresult = i;
                result = true;
            }
        }
     return result;
    }



}
