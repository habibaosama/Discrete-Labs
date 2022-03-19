package Discrete;
public class CRT {

    public static long[] changeToArray (String s){
        //Parsing the entered string into an array.
        long[] arr = new long[s.split(",").length];
        for (int i = 0; i < s.split(",").length; i++) {
            arr[i] = Integer.valueOf(s.split(",")[i]);
        }
        return arr;
    }

    public static long getMInverse(long m,long M) {
        //Getting the M inverse.
        long i=1;
        while(true){
            if((m*i)%M==1){
                break;
            }else{
                i++;
            }
        }
        return i;
    }

    public static void crt(String s1,String s2){
        
        long[] arra = changeToArray(s1);
        long[] arrm = changeToArray(s2);
        
        long M=arrm[0];
        
        //Getting the M which is equal to m1*m2*m3*....
        for(int i=1;i<arra.length;i++){
            M*=arrm[i];

        }
        
        long[] arrM = new long[arra.length];
        long[] arrMinv = new long[arra.length];
        
        //Getting values of M1, M2, M3,....
        for(int i=0;i<arra.length;i++){
           arrM[i]=M/arrm[i];
        }

        //Getting values of M1 inverse, M2 inverse, M3 inverse,.....
        for(int i=0;i<arra.length;i++){
            arrMinv[i]=getMInverse(arrM[i],arrm[i]);
        }
        
        long x=0;
        //Calculating x at last, x=a1*M1*M1inverse+a2*M2*M2inverse+....
        for(int i=0;i<arra.length;i++){
            x+=arra[i]*arrM[i]*arrMinv[i];
        }

        long k=x%M;
        System.out.println("x conjugate to "+k+" modulo "+M);
        System.out.println("x = "+k+" + "+M+"k , where k belongs to Z");


    }


}