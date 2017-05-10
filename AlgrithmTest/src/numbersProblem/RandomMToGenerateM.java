package numbersProblem;

/*
 * ͨ������M�����������������N�������
 * 	����һ���ȸ����������1~M���������rand1ToM:
 * 	����֮�ⲻ��ʹ���κζ����������ƣ�����������������ֱ�Ϊm��n��
 * ����randomToMʵ�ֵȸ����������1~N���������
 * 	������ĳһ�����ϵ��������������ʵ�����������ϵ����������
 * 	����K��randomToM������Kλ��M������
 */
public class RandomMToGenerateM {
	
	public static void main(String[] args){
		RandomMToGenerateM rand = new RandomMToGenerateM();
		for(int i= 0; i< 10; i++){
			System.out.println(rand.randomToN(7, 5));
		}
		
	}
	
	//��֪
	public int randToM(int m){
		return (int) (Math.random() * m )+ 1;
	}

	public int randomToN(int n,int m){
		int[] nMsys = getMsysNum(n - 1, m);
		int[] randNum = getRandMSysNumLessN(nMsys, m);
		return getNumFromMsysNum(randNum, m);
	}
	
	//��nת��Ϊm������
	public int[] getMsysNum(int value,int m){
		int[] res = new int[32];
		int index = res.length - 1;
		while(value != 0){
			res[index--] = value % m;
			value = value / m;
		}
		return res;
	}
	
	//�ȸ����������һ��0~nMsys��Χ������ֻ��������m���Ʊ���
	public int[] getRandMSysNumLessN(int[] nMsys,int m){
		int res[] = new int[nMsys.length];
		//�ҵ�n�ķ�Χ
		int start = 0;
		while(nMsys[start] == 0)
			start++;
		
		int index = start;
		//���ܲ�������n������������Ҫ�ж�res���һλ�Ƿ񳬳���Χ
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
	
	//��m������ת����10����
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
