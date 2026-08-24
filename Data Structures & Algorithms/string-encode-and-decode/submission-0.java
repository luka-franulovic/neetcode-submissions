class Solution {

    public String encode(List<String> strs) {
        String result = "";
        for (String s : strs){
            result += s;
            result += "ж";
        }
        return result;
    }

    public List<String> decode(String str) {
        ArrayList<String> decoded = new ArrayList<String>();
        String tmp = "";
        for (int i = 0; i < str.length(); i++){
            if ((int)str.charAt(i) > 0 && (int)str.charAt(i) <= 127){
                tmp += str.charAt(i);
            }
            else{
                decoded.add(tmp);
                tmp = "";
            }
        }
        return decoded;

    }
}
