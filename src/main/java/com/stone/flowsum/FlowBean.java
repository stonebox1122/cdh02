package com.stone.flowsum;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class FlowBean implements Writable {
	
	private long upFlow; //上行流量
	private long downFlow; //下行流量
	private long sumFlow; //总流量
	
	//无参构造，为了后续反射使用
	public FlowBean() {
		super();
	}

	public FlowBean(long upFlow, long downFlow) {
		super();
		this.upFlow = upFlow;
		this.downFlow = downFlow;
		sumFlow = upFlow + downFlow;
	}

	public long getUpFlow() {
		return upFlow;
	}

	public void setUpFlow(long upFlow) {
		this.upFlow = upFlow;
	}

	public long getDownFlow() {
		return downFlow;
	}

	public void setDownFlow(long downFlow) {
		this.downFlow = downFlow;
	}

	public long getSumFlow() {
		return sumFlow;
	}

	public void setSumFlow(long sumFlow) {
		this.sumFlow = sumFlow;
	}

	@Override
	public String toString() {
		return upFlow + "\t" + downFlow + "\t" + sumFlow;
	}

	//序列化方法
	@Override
	public void write(DataOutput out) throws IOException {
		out.writeLong(upFlow);
		out.writeLong(downFlow);
		out.writeLong(sumFlow);
	}

	//反序列化方法
	@Override
	public void readFields(DataInput in) throws IOException {
		//必须要求和序列化方法顺序一致
		upFlow = in.readLong();
		downFlow = in.readLong();
		sumFlow = in.readLong();
	}

	public void set(long sum_upFlow, long sum_downFlow) {
		this.upFlow = sum_upFlow;
		this.downFlow = sum_downFlow;
		this.sumFlow = upFlow + downFlow;
	}
	
	
}
