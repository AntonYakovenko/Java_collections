package entities;

import java.util.*;

public class EntityC {
    private final EntityA entity;
    private final List<EntityB> list;
    private final Map<Set<EntityA>, List<EntityB[]>> map;

    EntityC(EntityA entity, List<EntityB> list, Map<Set<EntityA>, List<EntityB[]>> map) {
        this.entity = entity;
        this.list = list;
        this.map = map;
    }

    public EntityA getEntity() {
        return entity;
    }

    public List<EntityB> getList() {
        return list;
    }

    public Map<Set<EntityA>, List<EntityB[]>> getMap() {
        return map;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        EntityC that = (EntityC) obj;
        //Check 1-st field
        if (!Objects.equals(this.entity, that.entity)) {
            return false;
        }
        //Check 2-nd field
        if (this.list.size() != that.list.size()) {
            return false;
        }
        for (int i = 0; i < this.list.size(); i++) {
            if (this.list.get(i) != that.list.get(i)) {
                return false;
            }
        }
        //Check 3-rd field
        if (this.map.size() != that.map.size()) {
            return false;
        }

        Iterator<Map.Entry<Set<EntityA>, List<EntityB[]>>> thisIterator = this.map.entrySet().iterator();
        Iterator<Map.Entry<Set<EntityA>, List<EntityB[]>>> thatIterator = that.map.entrySet().iterator();
        while (thisIterator.hasNext() && thatIterator.hasNext()) {
            Map.Entry<Set<EntityA>, List<EntityB[]>> thisPair = thisIterator.next();
            Map.Entry<Set<EntityA>, List<EntityB[]>> thatPair = thatIterator.next();
            if(!(thisPair.getKey().containsAll(thatPair.getKey()))
                    || !checkValuesEquality(thisPair.getValue(), thatPair.getValue())) {
                return false;
            }
        }

//        for (Set<EntityA> thisElem : this.map.keySet()) {
//            for (Set<EntityA> thatElem : that.map.keySet()) {
//                if(!thisElem.containsAll(thatElem)) {
////                for (EntityA thisKeySetElem : thisElem) {
////                    if (!thatElem.contains(thisKeySetElem)) {
//                        return false;
//                    }
////                }
//            }
//        }
//        for (Set<EntityA> key : this.map.keySet()) {
//            if (this.map.get(key).size() != that.map.get(key).size()) {
//                return false;
//            }
//            for (int i = 0; i < this.map.get(key).size(); i++) {
//                if (!Arrays.equals(this.map.get(key).get(i), that.map.get(key).get(i))) {
//                    return false;
//                }
//            }
//        }
        return true;
    }

    private boolean checkValuesEquality(List<EntityB[]> value1, List<EntityB[]> value2) {
        for (int i = 0; i < value1.size(); i++) {
            if (!Arrays.equals(value1.get(i), value2.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = entity.hashCode();
        int hashCodeKeys = 0;
        int hashCodeValues = 0;
        for (EntityB elem : list) {
            result = 31 * result + elem.hashCode();
        }
        for (Set<EntityA> elem : map.keySet()) {
            for (EntityA entityAElem : elem) {
                hashCodeKeys = 31 * hashCodeKeys + entityAElem.hashCode();
            }
            for(EntityB[] listEntityBArr : map.get(elem)) {
                hashCodeValues = 31 * hashCodeValues + Arrays.hashCode(listEntityBArr);
            }
            result = 31 * result + hashCodeKeys ^ hashCodeValues;
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("EntityC{" + "entity=").append(entity).append(", list=").append(list).append(", map=[");
        StringBuilder mapstr = new StringBuilder();
        for (Set<EntityA> elem : map.keySet()) {
            mapstr.append(elem).append("=");
            int counter = 0;
            for (EntityB[] listElem : map.get(elem)) {
                if (counter != map.get(elem).size() - 1) {
                    mapstr.append(Arrays.toString(listElem)).append(", ");
                    counter++;
                } else {
                    mapstr.append(Arrays.toString(listElem));
                }
            }
        }
        result.append(mapstr).append("]}");
        return String.valueOf(result);
    }
}
