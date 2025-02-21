import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<Data> dataList = new ArrayList<>();

    public void create(String name, Integer mark, String group, String subject) {
        Data data = new Data();
        data.setPersonInf(name);
        data.setGroup(group);
        data.setSubject(subject);
        data.setMark(mark);
        dataList.add(data);
    }

    public List<Data> find(String searchString) {
        List<Data> foundData = new ArrayList<>();
        for (Data searchData : dataList) {
            if (searchData.getSubject().equals(searchString)) {
                foundData.add(searchData);
            }
        }
        return foundData;
    }


    public Data update(String name, String subject, Integer newMark) {
        for (Data data : dataList) {
            if (data.getPersonInf().equals(name) && data.getSubject().equals(subject)) {
                data.setMark(newMark);
                return data;
            }
        }

        return null;
    }


    public int delete(String name, String subject) {
        int indexToRemove = -1;
        for (int i = 0; i < dataList.size(); i++) {
            Data data = dataList.get(i);
            if (data.getPersonInf().equals(name) && data.getSubject().equals(subject)) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove != -1) {
            dataList.remove(indexToRemove);
        }

        return indexToRemove;
    }
}
