package com.stone.index;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TwoIndexMapper extends Mapper<LongWritable, Text, Text, Text> {
	
	Text k = new Text();
	Text v = new Text();
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		// 1 获取一行 ：atguigu--a.txt	3
		String line = value.toString();
		
		// 2 切割
		String[] fields = line.split("--");
		
		// 3 封装
		k.set(fields[0]);
		v.set(fields[1]);
		
		// 4 写出
		context.write(k, v);
		
	}

}
