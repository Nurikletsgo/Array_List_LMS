package service.serviceImpl;

import model.DataBase;
import model.GeneratedId;
import model.Library;
import model.Reader;
import service.ReaderService;

import java.util.List;
import java.util.Scanner;

public class ReaderServiceImpl implements ReaderService {

    public void getReaderMenu() {
        boolean choose = true;
        while (choose) {
            System.out.println("""
                    1. Add reader
                    2. Get all reader
                    3. Get reader by ID
                    4. Update reader
                    5. Assign reader to library
                    6. exit""");
            try {
                switch (new Scanner(System.in).nextInt()) {
                    case 1:
                        Reader reader = new Reader();
                        reader.setId(GeneratedId.getReaderId());
                        reader.setFullName();
                        reader.setEmail();
                        reader.setPhoneNumber();
                        reader.setGender();
                        saveReader(reader);
                        break;
                    case 2:
                        System.out.println(getAllReaders());
                        break;
                    case 3:
                        System.out.println("write reader ID");
                        getReaderById(new Scanner(System.in).nextLong());
                        break;
                    case 4:
                        Reader reader1 = new Reader();
                        System.out.println("write reader ID which you want to update ");
                        Long ID = new Scanner(System.in).nextLong();
                        System.out.println("write new reader information ");
                        reader1.setId(ID);
                        reader1.setFullName();
                        reader1.setEmail();
                        reader1.setPhoneNumber();
                        reader1.setGender();
                        System.out.println(updateReader(ID, reader1));
                        break;
                    case 5:
                        System.out.println("write reader ID which you want ");
                        Long readerId = new Scanner(System.in).nextLong();
                        System.out.println("write library ID");
                        Long libraryId = new Scanner(System.in).nextLong();
                        assignReaderToLibrary(readerId,libraryId);
                        break;
                    case 6: choose = false;
                    break;
                    default:
                        System.err.println("choose only number 1-2-3-4-5-6 ");
                }
            }catch (Exception e){
                System.err.println("write again");
            }
        }
    }

    @Override
    public void saveReader(Reader reader) {
        DataBase.readers.add(reader);
        System.out.println(reader + "\n Success added");
    }

    @Override
    public List<Reader> getAllReaders() {
        return DataBase.readers;
    }

    @Override
    public Reader getReaderById(Long id) {
        Reader reader1 = new Reader();
        for (Reader reader : DataBase.readers) {
            if (reader.getId().equals(id)) {
                reader1 = reader;
            }
        }
        return reader1;
    }

    @Override
    public Reader updateReader(Long id, Reader reader) {
        for (Reader reader2 : DataBase.readers) {
            if (id.equals(reader2.getId())) {
                DataBase.readers.set(Math.toIntExact(id), reader);

            }
        }
        return reader;
    }

    @Override
    public void assignReaderToLibrary(Long readerId, Long libraryId) {
        for (Reader reader : DataBase.readers) {
            if (reader.getId().equals(readerId)) {
                for (Library library : DataBase.libraries) {
                    if (library.getLibraryId().equals(libraryId)) {
                        library.setReaders(DataBase.readers);
                    }
                }
            }
        }
    }
}
