package in.guvi.fraud.service;
import weka.classifiers.trees.RandomForest;import weka.core.*;import weka.core.converters.CSVLoader;import java.io.*;
/** Demonstration supervised model. Training CSV is synthetic, not production evidence. */
public class MlFraudModel {
 private RandomForest model;private Instances header;private int rows;
 public synchronized void train()throws Exception{try(InputStream in=getClass().getResourceAsStream("/training-transactions.csv")){if(in==null)throw new FileNotFoundException("training-transactions.csv");File f=File.createTempFile("fraud",".csv");try{try(OutputStream o=new FileOutputStream(f)){in.transferTo(o);}CSVLoader l=new CSVLoader();l.setNominalAttributes("5");l.setSource(f);Instances d=l.getDataSet();d.setClassIndex(d.numAttributes()-1);rows=d.numInstances();RandomForest r=new RandomForest();r.setNumIterations(80);r.setMaxDepth(8);r.setSeed(42);r.buildClassifier(d);model=r;header=new Instances(d,0);}finally{f.delete();}}}
 public synchronized double probability(double amount,int highRisk,int unverified,int recent)throws Exception{if(model==null)train();DenseInstance x=new DenseInstance(header.numAttributes());x.setDataset(header);x.setValue(0,amount);x.setValue(1,highRisk);x.setValue(2,unverified);x.setValue(3,recent);x.setMissing(4);double[] d=model.distributionForInstance(x);int ix=header.classAttribute().indexOfValue("1");return d[ix<0?d.length-1:ix];}
 public int rows(){return rows;}
}
