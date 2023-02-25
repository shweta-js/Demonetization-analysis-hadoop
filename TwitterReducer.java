//SalesCountryReducer.java
package TwitterDemo;
import java.io.IOException;
import java.util.*;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;
public class TwitterReducer extends MapReduceBase implements Reducer<Text, IntWritable,
Text, IntWritable> {
public void reduce(Text t_key, Iterator<IntWritable> values,
OutputCollector<Text,IntWritable> output, Reporter reporter) throws IOException {
Text key = t_key;
int frequencyForTweets = 0;
while (values.hasNext()) {
// replace type of value with the actual type of our value
IntWritable value = (IntWritable) values.next();
frequencyForTweets += value.get();
}
output.collect(key, new IntWritable(frequencyForTweets));
}
}
