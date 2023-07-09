import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

public class TeamScoreCalculator {
  public static class TeamScoreMapper extends Mapper<Object, Text, Text, IntWritable> {
    private final Text team = new Text();
    private final IntWritable score = new IntWritable();

    public void map(Object key, Text value, Context context)
        throws IOException, InterruptedException {
      String[] fields = value.toString().split(",");
      String teamName = fields[4];
      int runScored = Integer.parseInt(fields[8]);
      team.set(teamName);
      score.set(runScored);
      context.write(team, score);
    }
  }

  public static class TeamScoreReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
    private final IntWritable totalScore = new IntWritable();

    public void reduce(Text key, Iterable<IntWritable> values, Context context)
        throws IOException, InterruptedException {
      int sum = 0;
      for (IntWritable val : values) {
        sum += val.get();
      }
      totalScore.set(sum);
      context.write(key, totalScore);
    }
  }
}
