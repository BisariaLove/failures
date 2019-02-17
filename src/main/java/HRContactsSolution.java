import util.FileUtils;

import java.util.List;

/**
 * Created by lovebisaria on 02/09/17.
 */
public class HRContactsSolution {
    private static final String ADD_OPERATION = "add";
    private static final String FIND_OPERATION = "find";

    public static void main(String[] love) throws Exception{
        HRContactsSolution obj = new HRContactsSolution();

        //test standard input
        //obj.testStandardInput();

        //test from test cases
        obj.loadTestCasesAndTest();

    }

    public void loadTestCasesAndTest() throws Exception{
        List<String> contents = FileUtils.getResourceFileContentsAsList("/test_cases/contacts/input");

        if(contents.size() >0){
            TrieDataStructure trie = new TrieDataStructure();
            Integer numOfInput = Integer.parseInt(contents.get(0));
            String line = null;
            for(int k=1; k<=numOfInput; k++){
                line = contents.get(k);
                String[] inputs = line.split(" ");

                if(inputs[0].equals(ADD_OPERATION)){
                    trie.insertString(inputs[1]);
                }else if(inputs[0].equals(FIND_OPERATION)){
                    System.out.println(trie.searchCountOfPrefix(inputs[1]));
                }
            }
        }
    }

    public void testStandardInput() throws Exception{
        List<String> contents = FileUtils.getResourceFileContentsAsList("/inputs/contacts");

        if(contents.size() >0){
            TrieDataStructure trie = new TrieDataStructure();
            Integer numOfInput = Integer.parseInt(contents.get(0));
            String line = null;
            for(int k=1; k<=numOfInput; k++){
                line = contents.get(k);
                String[] inputs = line.split(" ");

                if(inputs[0].equals(ADD_OPERATION)){
                    trie.insertString(inputs[1]);
                }else if(inputs[0].equals(FIND_OPERATION)){
                    System.out.println(trie.searchCountOfPrefix(inputs[1]));
                }
            }
        }
    }
}
