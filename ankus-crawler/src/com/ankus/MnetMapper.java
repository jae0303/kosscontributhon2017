package com.song;


import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class MnetMapper extends
  Mapper<LongWritable, Text, Text, Text> {

  // map 출력값
  // map 출력키
  private Text outputKey = new Text();
  private Text outputValue = new Text();
  public void map(LongWritable key, Text value, Context context)
    throws IOException, InterruptedException {

    MnetParser parser = new MnetParser(value);

    // 출력키 설정
    if(parser.getsong()!=null){
    	outputKey.set(parser.getsong()+"ㅒ"+parser.getsinger()+"ㅒ"+parser.getalbum()+"ㅒ");
    	outputValue.set(parser.getdate()+"ㅒ"+parser.getrank());
      context.write(outputKey, outputValue);
    	}
  }
}
