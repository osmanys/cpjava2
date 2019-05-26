package on2019_05.on2019_05_22_TopCoder_Open_Round__1A.EllysCodeConstants;



public class EllysCodeConstants {
    public String getLiteral(String candidate) {
        StringBuilder sb = new StringBuilder("0x");
        int i = 0;
        String suffix = "";
        if(candidate.endsWith("LLU"))
            suffix = "LLU";
        else if(candidate.endsWith("ULL"))
            suffix = "ULL";
        else if(candidate.endsWith("ULL"))
            suffix = "ULL";
        else if(candidate.endsWith("UL"))
            suffix = "UL";
        else if(candidate.endsWith("LL"))
            suffix = "LL";
        else if(candidate.endsWith("LU"))
            suffix = "LU";
        else if(candidate.endsWith("L"))
            suffix = "L";
        else if(candidate.endsWith("U"))
            suffix = "U";
        for(; i < candidate.length() - suffix.length(); i++){
            if((candidate.charAt(i) >= '0' && candidate.charAt(i) <= '9') || (candidate.charAt(i) >= 'A' && candidate.charAt(i) <= 'F'))
                sb.append(candidate.charAt(i));
            else if(candidate.charAt(i) == 'O')
                sb.append(0);
            else if(candidate.charAt(i) == 'I')
                sb.append(1);
            else if(candidate.charAt(i) == 'Z')
                sb.append(2);
            else if(candidate.charAt(i) == 'S')
                sb.append(5);
            else if(candidate.charAt(i) == 'T')
                sb.append(7);
            else
                return "";
        }
        if(sb.length() == 0)
            return "";
        return sb.toString() + suffix;
    }
}