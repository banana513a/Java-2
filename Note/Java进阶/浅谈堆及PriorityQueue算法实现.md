#浅谈堆及PriorityQueue算法实现#

##堆介绍##
堆给人的感觉像是一个二叉树，但是其本质是一种数组对象。因为对堆进行操作的时候将堆视为一颗完全二叉树，树种每个节点与数组中的存放节点值的那个元素对应，所以堆又称为二叉堆。
以最大堆为例，堆与完全二叉树的对应，关系如下图所示：

![GitHub](https://github.com/blacky8/Pictures/blob/master/Heap_tree.jpg)

根据上图，如果我们从根结点开始按照从左到右依次编号，对这些元素的访问就构成了一个序列，如：16, 14, 10, 8, 7, 9, 3, 2, 4, 1，如果我们将这种从二叉树的结点关系转换成对应的数组形式的话，则对应的数组如下图：

![GitHub](https://github.com/blacky8/Pictures/blob/master/Heap_array.jpg)

根据二叉树每个结点和它的左右子结点的关系，假设给定节点为i，可以根据其在数组中的位置获取其父亲节点、左右孩子节点。
假设数组的下标是从1开始的，可以得到：

**PARENT(i) = i/2，LEFT(i) = 2*i，RIGHT(i) = 2*i+1**

Left对应代码：
```java
public static int left(int i)
{
	return i * 2;
}
```
Right对应代码：
```java
public static int right(int i)
{
	return i * 2 + 1;
}
```
根据节点数值满足的条件，可以将分为最大堆和最小堆：
<br>最大堆的特性是：除了根节点以外的每个节点i，有A[PARENT(i)] >= A[i]；
<br>最小堆的特性是：除了根节点以外的每个节点i，有A[PARENT(i)] >=A[i]。
  
若将堆看成一个棵树，有如下的特性：

  1. 含有n个元素的堆的高度是lgn。
  2. 当用数组表示存储了n个元素的堆时，叶子节点的下标是n/2+1，n/2+2，……，n。
  3. 在最大堆中，最大元素该子树的根上；在最小堆中，最小元素在该子树的根上。
  
##堆调整（MaxHeapify）##
前面已经理解了堆和对应的数组之间的关系，对于最大堆来说，它有一个重要的特性就是处于父结点的值必须比它的子结点要大。假设某一棵树上面的父结点不满足这个要求，就必须进行调整。一般来说，调整就是将这个不符合条件的结点和子结点进行比较，通过交换将最大的结点作为父结点。流程图如下：

![GitHub](https://github.com/blacky8/Pictures/blob/master/Heap_fix_a.jpg)

在上图中，我们发现值为4的结点不符合要求，那么就需要进行交换调整。接着就需要在它的两个子结点中选择最大的那个，然后交换位置。它的子结点中最大的是14.交换之后的结果如下图：

![GitHub](https://github.com/blacky8/Pictures/blob/master/Heap_fix_b.jpg)

经过交换之后，我们发现原来元素所在的位置确实符合要求，可是4交换到新的结点之后又不符合最大堆的条件，所以，还需要继续选择最大子结点进行交换。交换之后的结果如下：

![GitHub](https://github.com/blacky8/Pictures/blob/master/Heap_fix_c.jpg)

总结前面这么一个交换调整的过程，主要如下：

1. 比较当前结点和它的子结点，如果当前结点小于它的任何一个子结点，则和最大的那个子结点交换。否则，当前过程结束。
2. 在交换到新位置的结点重复步骤1，直到叶结点。

对上面的过程进行细化之后编码，可以得到两个版本的方法：

递归版本：  
```java
public static void maxHeapify(int[] a, int i)
{
	int l = left(i);
	int r = right(i);
	int largest = i;

	if(l < a.length && a[l] > a[i])
		largest = l;
	if(r < a.length && a[r] > a[largest])
		largest = r;
	if(i != largest)
	{
		swap(a, i, largest);
		maxHeapify(a, largest);
	}
}
```
非递归版本：
```java
public static void maxHeapify(int[] a, int i)
{
	int l = left(i);
	int r = right(i);
	int largest = i;
	while(true)
	{
		if(l < a.length && a[l] > a[i])
			largest = l;
		if(r < a.length && a[r] > a[largest])
			largest = r;
		if(i != largest)
			swap(a, i, largest);
		else
			break;
		i = largest;
		l = left(largest);
		r = right(largest);
	}
}
```
以上两个版本的实现主要有几个要点要注意：
  
  1. 每次求一个结点的子结点的时候要检查是否越界。 
  2. 每次通过将当前结点和子结点的比较来选取最大值，如果最大值就是当前结点，则程序返回。 
  3. 上面代码中的swap方法就是交换两个索引位置元素的位置，不在赘述。

##堆建立（BuildMaxHeap）##
前面说明了堆调整的过程，但只是针对一个树中的一个结点。如果树中间有多个结点不符合最大堆的条件，就不能只调整一个节点，而是需要将整棵树调整成符合条件的最大堆。
对于这种情况，最简单的方法是从下向上，从a[a.length -1]结点的父节点开始进行调整。下图说明了对于一个堆建立的调整过程：

![GitHub](https://github.com/blacky8/Pictures/blob/master/Heap_build.png)

堆建立代码如下：
```java
public static void buildMaxHeap(int[] a)
{
	for(int i = a.length / 2; i >= 0; i--)
		maxHeapify(a, i);
}
```

##最大堆算法实现-堆排序（HeapSort）##
堆排序，是利用最大堆进行排序的一种算法实现，其过程为：

1. 将输入数组创建成一个最大堆，使得最大的值存放在数组第一个位置；
2. 交换数组最后一个位置与第一个位置的元素；
3. 调用最大堆调整函数进行调整。
4. 重复步骤2，直到数组元素全部遍历完成

堆排序实现代码如下：
```java
public static void heapSort(int[] a)
{
	if(a == null || a.length <= 1)
		return;

	buildMaxHeap(a);
	int length = a.length;
	for(int i = a.length - 1; i > 0; i--)
	{
		swap(a, i, 0);
		length--;
		maxHeapify(a, 0, length);
	}
}
```
注意，这里maxHeapify方法有个细小的改变，就是增加了一个代表需要调整堆长度的参数。这样做的原因是每次交换当前集合最大元素时，它们已经被放到最后，堆调整的时候就可以不再考虑这些元素。

##最小堆算法实现-优先级队列（PriorityQueue）##
Java中PriorityQueue通过二叉小顶堆实现，可以用一棵完全二叉树表示。优先队列不同于普通的遵循FIFO(先进先出)的队列，它的作用是能保证每次取出的元素都是队列中权值最小的。
这里所说的大小关系，可以通过元素本身的自然顺序（natural ordering），也可以通过构造时传入的比较器（Comparator）来判断。
下面对JDK1.8中的PriorityQueue类的主要部分源码进行分析：
```java
//添加操作（add方法也是通过offer方法实现）
public boolean offer(E e) {
    if (e == null)  //判空，抛出异常
        throw new NullPointerException();
    modCount++;   //队列操作数增加
    int i = size;
    if (i >= queue.length)
        grow(i + 1);  //如果超出队列大小，队列扩容操作
    size = i + 1;   //队列大小增加
    if (i == 0)
        queue[0] = e; //如果队列中没有元素，直接赋值给队头元素
    else
        siftUp(i, e); //否则，进行上滤操作
    return true;
}
...
//扩容
private void grow(int minCapacity) {
  int oldCapacity = queue.length; //获取当前队列容量
  //当前队列大小queue.length<64，则增加一倍容量；反之则增加一半容量。
  int newCapacity = oldCapacity + ((oldCapacity < 64) ?
                                   (oldCapacity + 2) :
                                   (oldCapacity >> 1));
  //溢出检测
  if (newCapacity - MAX_ARRAY_SIZE > 0)
      newCapacity = hugeCapacity(minCapacity);
  queue = Arrays.copyOf(queue, newCapacity);  //复制队列到新队列
}
...
//上滤操作
private void siftUp(int k, E x) {
    if (comparator != null)
        siftUpUsingComparator(k, x);  //使用默认的比较器进行上滤操作
    else
        siftUpComparable(k, x); //使用构造队列时传入的比较器进行上滤操作
}
...
//使用默认比较器进行上滤（使用构造时传入的比较器进行上滤同理）
private void siftUpUsingComparator(int k, E x) {
    while (k > 0) {//循环寻找当前节点x的合适位置
        int parent = (k - 1) >>> 1; //获取k位置节点的父节点索引
        Object e = queue[parent]; //获取k位置节点的父节点
        if (comparator.compare(x, (E) e) >= 0)  //进行比较，如果当前节点x大于等于k位置节点的父节，退出循环
            break;
        queue[k] = e; //k位置节点的父节点下移
        k = parent; //改变k的位置为父节点位置
    }
    queue[k] = x; //将x节点放入找到的合适位置
}
...
//出队（删除元素）
public E poll() {
    if (size == 0)  //如果队列大小为0，则不出队
        return null;
    int s = --size; //减少队列大小
    modCount++; //增加队列操作数
    E result = (E) queue[0];  //队头元素作为结果返回
    E x = (E) queue[s]; //获取队列的最后元素 
    queue[s] = null;  //置空队列最后元素
    if (s != 0)
        siftDown(0, x); //如果删除后的队列大小不为0，对新的队头元素进行下滤操作
    return result;  
}
...
//下滤操作
private void siftDown(int k, E x) {
    if (comparator != null)
        siftDownUsingComparator(k, x);
    else
        siftDownComparable(k, x);
}
...
//使用默认的比较器进行下滤（使用构造时传入的比较器进行下滤同理）
private void siftDownUsingComparator(int k, E x) {
    int half = size >>> 1;  //计算非叶子节点元素的最大位置 
    while (k < half) {  //如果k位置不是叶节点
        int child = (k << 1) + 1; //获取k位置节点的左子节点下标
        Object c = queue[child];  //获取k位置节点的左子节点
        int right = child + 1;  //获取k位置节点的右子节点下标
        if (right < size &&
            comparator.compare((E) c, (E) queue[right]) > 0) //如果右子节点比左子节点小，重新赋值c
            c = queue[child = right];
        if (comparator.compare(x, (E) c) <= 0)  //如果x节点小于等于c节点，退出循环
            break;
        queue[k] = c; //父节点下移，c节点替换父节点
        k = child;  //改变k位置
    }
    queue[k] = x; //将x节点放入找到的合适位置
}
...
//删除
private E removeAt(int i) {
    // assert i >= 0 && i < size;
    modCount++; //队列操作数增加
    int s = --size; //队列大小减少
    if (s == i) //删除元素为最后一个元素，置空
        queue[i] = null;
    else {
        E moved = (E) queue[s]; //获取队列最后一个元素，置空
        queue[s] = null;  
        siftDown(i, moved); //进行下滤
        if (queue[i] == moved) {  //如果下滤后i位置的节点不变，则进行上滤
            siftUp(i, moved);
            if (queue[i] != moved) // iterator中会用到此处
                return moved; 
        }
    }
    return null;
  }
```
以上是PriorityQueue的主要操作源代码，其他部分不再赘述。

综上所述，PriorityQueue本质上就是最小堆。最小堆满足的一个基本性质是堆顶端的元素是所有元素里最小的那个。如果将顶端的元素去掉之后，为了保持堆的性质，需要进行调整。
对堆的操作和调整主要包含三个方面，增加新的元素，删除顶端元素和建堆时保证堆性质的操作，相关内容前面已经做了详细介绍。 
另外，PriorityQueue在一些经典算法中也有得到应用，相当于是它们实现的基础。

参考文献：
* http://shmilyaw-hotmail-com.iteye.com/blog/1775868
* http://shmilyaw-hotmail-com.iteye.com/blog/1827136
* http://wlh0706-163-com.iteye.com/blog/1850125
