package com.mkyong.hashing;
import java.util.*;
abstract class NewYearGift{
	abstract int[] getWeight(int n);
	abstract int[] sort(int[] a,int n);
}
class App extends NewYearGift{
	public int[] getWeight(int n)
	{
		Scanner s=new Scanner(System.in);
		int gif=n;
		int g[]=new int[gif];
		for(int i=0;i<gif;i++)
		{
			g[i]=s.nextInt();			
		}
		return g;
	}
	public int[] sort(int a[],int n)
	{
		int i,temp;
		for(i=0;i<n;i++)
	{
		for(int j=i+1;j<n;j++)
		{
			if(a[i]<a[j])
			{
				temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}
		}
	}
	return a;
}
	public static void main(String[] args) {
		NewYearGift ne=new App();
		int n,i,ulimit,llimit;
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter no.of Gifts");
		n=obj.nextInt();
		int gifts[]=new int[n];
		int chocolates[]=new int[n];
		int sweets[]=new int[n];
		System.out.println("Enter Range of upper and lower limits");
		ulimit=obj.nextInt();
		llimit=obj.nextInt();
		System.out.println("Enter weights of gifts in the range of "+llimit+"to"+ulimit);
		gifts=ne.getWeight(n);
		gifts=ne.sort(gifts,n);
		for(i=0;i<n;i++)
		{
			if(gifts[i]>ulimit || gifts[i] <llimit)
			{
				System.out.println("Give gifts  weights only with in the range of given upper and lower limits");
			System.exit(0);
			}
		}
		App g=new Chocolate();
		llimit=gifts[n-1]-60;
		ulimit=gifts[0]-60;
		if(llimit<=0)
		{
			llimit=0;
		}
		if(ulimit<=0)
			ulimit=0;
		System.out.println("Enter weights of gifts in the range of "+llimit+"to"+ulimit);
		chocolates=g.getWeight(n);
		chocolates=g.sort(chocolates,n);
		for(i=0;i<n;i++)
		{
			if(chocolates[i]>ulimit || chocolates[i] <llimit)
			{
				System.out.println("Give chocolate weights only with in the range of given upper and lower limits");
			System.exit(0);
			}
		}
		Sweets s=new Sweets();
		sweets=s.getCandies(gifts,chocolates,n);
		System.out.println("Hence Weights of  Candies are");
		for(i=0;i<n;i++)
		{
			if(sweets[i]<0)
			{
				System.out.println("This Gift box is filled with chocolates..! don't have space for candies");
			}
			else
				
			System.out.println(sweets[i]);
		}
	}
}
class Chocolate extends App
{
	int chokies;
	Scanner cobj=new Scanner(System.in);
	public int[] getWeight(int n)
	{
		chokies=n;
		int c[]=new int[chokies];
		for(int i=0;i<chokies;i++)
			c[i]=cobj.nextInt();
		return c;
	}
	public int[] sort(int a[],int n)
	{
		int i,temp;
		for(i=0;i<n;i++)
	{
		for(int j=i+1;j<n;j++)
		{
			if(a[i]<a[j])
			{
				temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}
		}
	}
	return a;
}
}
class Sweets extends App{
	public int[] getCandies(int[] ng,int[] nc,int size)
	{
		int candies[]=new int[size];
		for (int i=0;i<size;i++)
		{
				candies[i]=ng[i]-nc[i];
		}
		return candies;
	}
}