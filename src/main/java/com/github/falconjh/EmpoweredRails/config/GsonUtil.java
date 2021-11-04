package com.github.falconjh.EmpoweredRails.config;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.HashMap;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.CharSet;
import com.github.falconjh.EmpoweredRails.EmpoweredRails;
import org.apache.logging.log4j.Logger;

public class GsonUtil {
    public static final Gson Serializer = new GsonBuilder().setPrettyPrinting().create();

    @SuppressWarnings("unchecked")
    public static <T> T getcreateConfigFile(Path configfile, T defaults, Type type){
        if(!configfile.toFile().exists())
        {
            //creating
            writeFile(configfile, defaults);
        }
        try
        {
            //reading
            return (T) Serializer.fromJson(FileUtils.readFileToString(configfile.toFile(),(String)null), type);
        } catch (JsonSyntaxException | IOException e) {
            EmpoweredRails.LOGGER.error(e);
        }
        return null;
    }

    protected static boolean writeFile(Path configfile, Object defaults)
    {
        try{
            FileUtils.write(configfile.toFile(), Serializer.toJson(defaults), (String) null);
            return true;
        } catch (IOException e) {
            EmpoweredRails.LOGGER.error(e);
            return false;
        }
    }
}
