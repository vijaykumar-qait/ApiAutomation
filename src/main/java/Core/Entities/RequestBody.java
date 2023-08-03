package Core.Entities;

import Helper.TestHelper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@NoArgsConstructor
@Getter
@Setter
public class RequestBody {
    private Class objectClass;
    private Object objectInstance;
    private File jsonFile;

    public RequestBody(Class objectClass, Object objectInstance) {
        this.objectClass = objectClass;
        this.objectInstance = objectInstance;
    }

    public RequestBody(File jsonFile) {
        this.jsonFile = jsonFile;
    }

    public String getBodyAsString(){
        if(objectInstance == null){
            String data;
            try {
                return new String(Files.readAllBytes(Paths.get(String.valueOf(jsonFile))));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if(objectInstance.getClass() == String.class){
            return objectInstance.toString();
        }
        return TestHelper.getJsonString(objectInstance);
    }
}
