/**
 * 
 */
package com.GroupName.bank.TestDemo.Domin;

/**
 * TODO
 * 
 * @author Prince
 * @date 2020年4月27日
 */
public class People {
	private int id;
	private String name;
	private double qq;
	private String job;
	private String time;
	private String university;
	private int number;
	private String src;
	private String target;
	private String senior;
	private String understand;

	

	@Override
	public String toString() {
		return "People [id=" + this.id + ", name=" + this.name + ", qq=" + qq + ", job=" + job + ", time=" + time
				+ ", university=" + university + ", number=" + number + ", src=" + src + ", target=" + target
				+ ", senior=" + senior + ", understand=" + understand + "]";
	}

	/**
	 * 
	 */
	public People() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param name
	 * @param qq
	 * @param job
	 * @param time
	 * @param university
	 * @param number
	 * @param src
	 * @param target
	 * @param senior
	 * @param understand
	 * @param creat_at
	 * @param update_at
	 */
	public People(int id, String name, double qq, String job, String time, String university, int number, String src,
			String target, String senior, String understand, String creat_at, String update_at) {
		super();
		this.id = id;
		this.name = name;
		this.qq = qq;
		this.job = job;
		this.time = time;
		this.university = university;
		this.number = number;
		this.src = src;
		this.target = target;
		this.senior = senior;
		this.understand = understand;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getQq() {
		return qq;
	}

	public void setQq(double qq) {
		this.qq = qq;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getSenior() {
		return senior;
	}

	public void setSenior(String senior) {
		this.senior = senior;
	}

	public String getUnderstand() {
		return understand;
	}

	public void setUnderstand(String understand) {
		this.understand = understand;
	}

}
