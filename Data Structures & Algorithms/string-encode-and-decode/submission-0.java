class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder("");
        for(String word: strs){
            int size = word.length();
            sb.append(size);
            sb.append('#');
            sb.append(word);
        }

        return sb.toString();

    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList();
        int i = 0;
        while (i < str.length()) {
            int sharpIndex = str.indexOf('#', i);
            int size = Integer.parseInt(str.substring(i, sharpIndex));
            i = sharpIndex + 1;
            String s = str.substring(i, i + size);
            list.add(s);
            i += size;
        }
        return list;
    }
}
