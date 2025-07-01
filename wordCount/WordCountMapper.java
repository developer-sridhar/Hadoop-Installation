package com.example.wordcount;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();

    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        // Convert to uppercase for case-insensitivity
        StringTokenizer tokenizer = new StringTokenizer(line.toUpperCase());
        while (tokenizer.hasMoreTokens()) {
            // Remove non-alphabetic characters before processing
            String token = tokenizer.nextToken().replaceAll("[^A-Z]", "");
            if (!token.isEmpty()) { // Ensure we don't emit empty strings
                word.set(token);
                context.write(word, one);
            }
        }
    }
}
