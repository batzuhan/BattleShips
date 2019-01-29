package Model;

import java.io.*;

public class FileOperations {

    public static void writeToFile(File path, Game game) {
        try (ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream(path))) {
            write.writeObject(game);
        } catch (NotSerializableException nse) {
        } catch (IOException eio) {
        }
    }

    public static Object readFromFile(File path) {
        Object game = null;

        try (ObjectInputStream inFile = new ObjectInputStream(new FileInputStream(path))) {
            game = inFile.readObject();
            return game;
        } catch (ClassNotFoundException cnfe) {
        } catch (FileNotFoundException fnfe) {
        } catch (IOException e) {
        }
        return game;
    }
}
