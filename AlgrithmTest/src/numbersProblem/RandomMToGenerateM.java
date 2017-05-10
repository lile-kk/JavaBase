package numbersProblem;

/*
 * 通过产生M的随机数函数，产生N的随机数
 * 	给定一个等概率随机产生1~M的随机函数rand1ToM:
 * 	除此之外不能使用任何额外的随机机制，有两个输入参数，分别为m和n，
 * 请用randomToM实现等概率随机产生1~N的随机函数
 * 	：给定某一区间上的随机函数，可以实现任意区间上的随机函数，
 * 	调用K次randomToM，生成K位的M进制数
 */
public class RandomMToGenerateM {
	
	public static void main(String[] args){
		RandomMToGenerateM rand = new RandomMToGenerateM();
		for(int i= 0; i< 10; i++){
			System.out.println(rand.randomToN(7, 5));
		}
		
	}
	
	//已知
	public int randToM(int m){
		return (int) (Math.random() * m )+ 1;
	}

	public int randomToN(int n,int m){
		int[] nMsys = getMsysNum(n - 1, m);
		int[] randNum = getRandMSysNumLessN(nMsys, m);
		return getNumFromMsysNum(randNum, m);
	}
	
	//将n转换为m进制数
	public int[] getMsysNum(int value,int m){
		int[] res = new int[32];
		int index = res.length - 1;
		while(value != 0){
			res[index--] = value % m;
			value = value / m;
		}
		return res;
	}
	
	//等概率随机产生一个0~nMsys范围的数，只不过是用m进制表达的
	public int[] getRandMSysNumLessN(int[] nMsys,int m){
		int res[] = new int[nMsys.length];
		//找到n的范围
		int start = 0;
		while(nMsys[start] == 0)
			start++;
		
		int index = start;
		//不能产生大于n的数，所以需要判断res最后一位是否超出范围
		boolean lastIndex = true;
		while(index != nMsys.length){
			res[index] = randToM(m) - 1;
			if(lastIndex){
				if(res[index] > nMsys[index]){
					index = start;
					lastIndex = true;
					continue;
				}else {
					lastIndex = res[index] == nMsys[index];
				}
			}
			index++;
		}
		return res;
	}
	
	//把m进制数转换成10进制
	public int getNumFromMsysNum(int[] mSys,int m){
		int res = 0;
		for(int i = 0; i< mSys.length; i++){
			res = res * m + mSys[i];
		}
		return res;
	}
	
	
}

class Rand5To{
	public int randTo5(){
		return (int)(Math.random()*5) + 1;
	}
	public int randTo7(){
		int num = 0;
		do{
			num = (randTo5() - 1) * 5 + randTo5() - 1;
		}while(num > 20);
		return num % 7 + 1;
	}
}
