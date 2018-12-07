/* Entry Interface
 * @author Er Lin 
 */
public interface Entry<K, V> extends Comparable<Entry<K, V>>
{
	K getKey();
	V getValue();
}
