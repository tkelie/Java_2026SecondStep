package step6_cli;

import java.util.HashMap;
import java.util.Map;

public class CliParser {

    public static Map<String,String> parse(String[] args){

        Map<String,String> map = new HashMap<>();

        for(int i=0;i<args.length;i++){

            String arg = args[i];

            if(arg.startsWith("--")){

                if(i+1 < args.length && !args[i+1].startsWith("--")){
                    map.put(arg,args[++i]);
                }else{
                    map.put(arg,"true");
                }
            }
        }

        return map;
    }
}