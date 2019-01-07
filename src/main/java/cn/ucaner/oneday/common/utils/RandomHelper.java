/******************************************************************************
* ~ Copyright (c) 2019 [jasonandy@hotmail.com | https://github.com/Jasonandy] *
* ~                                                                           *
* ~ Licensed under the Apache License, Version 2.0 (the "License”);           * 
* ~ you may not use this file except in compliance with the License.          *
* ~ You may obtain a copy of the License at                                   *
* ~                                                                           *
* ~    http://www.apache.org/licenses/LICENSE-2.0                             *
* ~                                                                           *
* ~ Unless required by applicable law or agreed to in writing, software       *
* ~ distributed under the License is distributed on an "AS IS" BASIS,         *
* ~ WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  *
* ~ See the License for the specific language governing permissions and       *
* ~ limitations under the License.                                            *
******************************************************************************/
package cn.ucaner.oneday.common.utils;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.apache.commons.lang3.RandomUtils;

/**     
* @Package：cn.ucaner.oneday.common.utils   
* @ClassName：RandomHelper   
* @Description：   <p> 随机获取数据</p>
* @Author： - Jason    
* @CreatTime：2019年1月7日 下午8:32:00   
* @Modify By：   
* @ModifyTime：  2019年1月7日
* @Modify marker：   
* @version    V1.0
*/
public class RandomHelper extends RandomUtils{
	
	private static Random random;

	/**
	 * @Description: 双重校验锁获取一个Random单例
	 * @return Random
	 * @Autor: @Jason - jasonandy@hotmail.com
	 */
    public static Random getRandom() {
        if(random==null){
            synchronized (RandomHelper.class) {
                if(random==null){
                    random =new Random();
                }
            }
        }
        return random;
    }

    /**
     * @Description: 获得一个[0,max)之间的整数。
     * @param max
     * @return int
     * @Autor: @Jason - jasonandy@hotmail.com
     */
	public static int getRandomInt(int max) {
	    return Math.abs(getRandom().nextInt())%max;
	}

	/**
	 * @Description: 获得一个[0,max)之间的整数。
	 * @param max
	 * @return long
	 * @Autor: @Jason - jasonandy@hotmail.com
	 */
    public static long getRandomLong(long max) {
        return Math.abs(getRandom().nextInt())%max;
    }

    /**
     * @Description: 从list中随机取得一个元素
     * @param list   list
     * @return E     元素
     * @Autor: @Jason - jasonandy@hotmail.com
     */
    public static <E> E getRandomElement(List<E> list){
        return list.get(getRandomInt(list.size()));
    }

    /**
     * @Description: 从set中随机取得一个元素
     * @param set
     * @return E
     * @Autor: @Jason - jasonandy@hotmail.com
     */
    public static <E> E getRandomElement(Set<E> set){
        int rn = getRandomInt(set.size());
        int i = 0;
        for (E e : set) {
            if(i==rn){
                return e;
            }
            i++;
        }
        return null;
    }

    /**
     * @Description: 从map中随机取得一个key
     * @param map
     * @return K
     * @Autor: @Jason - jasonandy@hotmail.com
     * @CreateTime : @2019年1月7日
     */
    public static <K,V> K getRandomKeyFromMap(Map<K,V> map) {
        int rn = getRandomInt(map.size());
        int i = 0;
        for (K key : map.keySet()) {
            if(i==rn){
                return key;
            }
            i++;
        }
        return null;
    }

    /**
     * @Description: 从map中随机取得一个value
     * @param map
     * @return V
     * @Autor: @Jason - jasonandy@hotmail.com
     * @CreateTime : @2019年1月7日
     */
    public static <K,V> V getRandomValueFromMap(Map<K,V> map) {
        int rn = getRandomInt(map.size());
        int i = 0;
        for (V value : map.values()) {
            if(i==rn){
                return value;
            }
            i++;
        }
        return null;
    }

    /**
     * @Description: JUST4TEST
     * @param args void
     * @Autor: @Jason - jasonandy@hotmail.com
     */
    public static void main(String[] args) {
    }

}
