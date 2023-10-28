package by.kovalski.customarray.service.impl;

import by.kovalski.customarray.entity.CustomArray;
import by.kovalski.customarray.exception.CustomException;
import by.kovalski.customarray.service.SortService;


import java.util.Stack;

public class SortServiceImpl implements SortService {
 private static SortServiceImpl INSTANCE;
 @Override
 public void bubbleSort(CustomArray array) throws CustomException {
  if (array == null) {
   throw new CustomException("Null pointer");
  }
  int[] copy = array.getArray();
  if (copy.length == 0) {
   throw new CustomException("Empty array");
  }
  int temp = 0;
  for (int i = 1; i < copy.length; i++)
   for (int j = 1; j <= copy.length - i; j++)
    if (copy[j] < copy[j - 1]) {
     temp = copy[j - 1];
     copy[j - 1] = copy[j];
     copy[j] = temp;
    }
  array.setArray(copy);
 }

 @Override
 public void quickSort(CustomArray array) throws CustomException {
  if (array == null) {
   throw new CustomException("Null pointer");
  }
  int[] copy = array.getArray();
  if (copy.length == 0) {
   throw new CustomException("Empty array");
  }
  int i, j, left = 0, right = copy.length - 1, p, t, p1;
  Stack<Integer> stack = new Stack<>();
  stack.push(left);
  stack.push(right);
  do {
   right = stack.pop();
   left = stack.pop();
   i = left;
   j = right;
   p = (i + j) / 2;
   p1 = copy[p];
   do {
    while (copy[i] < p1)
     i++;
    while (copy[j] > p1)
     j--;
    if (i <= j) {
     t = copy[i];
     copy[i] = copy[j];
     copy[j] = t;
     i++;
     j--;
    }
   } while (i <= j);
   if (left < j) {
    stack.push(left);
    stack.push(j);

   }
   if (right > i) {
    stack.push(i);
    stack.push(right);
   }
  } while (!stack.isEmpty());
  array.setArray(copy);
 }

 @Override
 public void mergeSort(CustomArray array) throws CustomException {//TODO
  if (array == null) {
   throw new CustomException("Null pointer");
  }
  int[] copy = array.getArray();
  if (copy.length == 0) {
   throw new CustomException("Empty array");
  }

 }

 @Override
 public void recursiveQuickSort(CustomArray array,int left,int right) throws CustomException {
  if (array == null) {
   throw new CustomException("Null pointer");
  }
  int[] copy = array.getArray();
  if (copy.length == 0) {
   throw new CustomException("Empty array");
  }
  int i= left, j= right;
  int p, pv, temp;
  p = (left + right) / 2;
  pv = copy[p];
  do {
   while (copy[i] < pv && i < right) i++;
   while (copy[j] > pv && j > left)j--;
   if (i <= j) {
    temp = copy[i];
    copy[i] = copy[j];
    copy[j] = temp;
    i++; j--;
   }

  } while (i <= j);
  array.setArray(copy);
  if (left < j) recursiveQuickSort(array, left, j);
  if (i < right) recursiveQuickSort(array, i, right);

 }
 private SortServiceImpl(){

 }
 public static SortServiceImpl getInstance(){
  if(INSTANCE == null){
   INSTANCE = new SortServiceImpl();
  }
  return INSTANCE;
 }
}
