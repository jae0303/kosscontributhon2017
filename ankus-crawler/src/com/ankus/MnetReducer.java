
package com.song;
import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Reducer;

public class MnetReducer extends Reducer<Text, Text, Text, Text> {
  // 출력키
  private Text outputKey = new Text();
  // 출력값
  private Text outputValue = new Text();
  
  private String temp="";
  public void reduce(Text key, Iterable<Text> values, Context context)
    throws IOException, InterruptedException {

    Iterator<Text> iterator = values.iterator();
    outputKey.set(key+"ㅒ");

    while (iterator.hasNext()) {
    	Text record = iterator.next();							// input[1]
    	temp += record.toString().trim();
    	}
    outputValue.set(temp);
    context.write(outputKey, outputValue);
    
  	}  
  }
  
  
  




