package on2019_04.on2019_04_30_TopCoder_SRM__144.BinaryCode;



public class BinaryCode {
    public String[] decode(String message) {
        int last0 = 0;
        int d, last1 = 0;
        StringBuilder sb0 = new StringBuilder();
        for(int i = 0; i < message.length(); i++){
            sb0.append(last1);
            d = message.charAt(i) - '0' - last0 - last1;
            if(d < 0 || d > 1){
                sb0 = new StringBuilder("NONE");
                break;
            }
            last0 = last1;
            last1 = d;
        }
        last0 = 0;
        last1 = 1;
        StringBuilder sb1 = new StringBuilder();
        for(int i = 0; i < message.length(); i++){
            sb1.append(last1);
            d = message.charAt(i) - '0' - last0 - last1;
            if(d < 0 || d > 1){
                sb1 = new StringBuilder("NONE");
                break;
            }
            last0 = last1;
            last1 = d;
        }
        return new String[] { sb0.toString(), sb1.toString() };
    }
}
