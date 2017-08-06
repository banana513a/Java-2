#浅谈红黑树及TreeMap算法实现#
R-B Tree，全称是Red-Black Tree，又称为“红黑树”，它一种特殊的二叉查找树。
红黑树的每个节点上都有存储位表示节点的颜色，可以是红(Red)或黑(Black)。

红黑树的应用比较广泛，主要是用它来存储有序的数据，它的时间复杂度是O(lgn)，效率非常之高。
例如，Java集合中的TreeSet和TreeMap，C++ STL中的set、map，以及Linux虚拟内存的管理，都是通过红黑树去实现的。

**红黑树的特性**

    1. 每个节点或者是黑色，或者是红色。
    2. 根节点是黑色。
    3. 每个叶子节点（NIL）是黑色。 [注意：这里叶子节点，是指为空(NIL或NULL)的叶子节点！]
    4. 如果一个节点是红色的，则它的子节点必须是黑色的。
    5. 从一个节点到该节点的子孙节点的所有路径上包含相同数目的黑节点。

**注意：**

    1. 特性3中的叶子节点，是只为空(NIL或null)的节点。
    2. 特性5，确保没有一条路径会比其他路径长出俩倍。因而，红黑树是相对是接近平衡的二叉树。

红黑树示意图如下：
![GitHub](https://github.com/blacky8/Pictures/blob/master/RBTree.jpg)

##红黑树的基本操作##
###左旋###
![GitHub](https://github.com/blacky8/Pictures/blob/master/RBTree_rotate_left.jpg)

对x进行左旋，意味着"将x变成一个左节点"。左旋的伪代码《算法导论》：
```java
LEFT-ROTATE(T, x)  
 y ← right[x]            // 前提：这里假设x的右孩子为y。下面开始正式操作
 right[x] ← left[y]      // 将 “y的左孩子” 设为 “x的右孩子”，即 将β设为x的右孩子
 p[left[y]] ← x          // 将 “x” 设为 “y的左孩子的父亲”，即 将β的父亲设为x
 p[y] ← p[x]             // 将 “x的父亲” 设为 “y的父亲”
 if p[x] = nil[T]       
 then root[T] ← y                 // 情况1：如果 “x的父亲” 是空节点，则将y设为根节点
 else if x = left[p[x]]  
           then left[p[x]] ← y    // 情况2：如果 x是它父节点的左孩子，则将y设为“x的父节点的左孩子”
           else right[p[x]] ← y   // 情况3：(x是它父节点的右孩子) 将y设为“x的父节点的右孩子”
 left[y] ← x             // 将 “x” 设为 “y的左孩子”
 p[x] ← y                // 将 “x的父节点” 设为 “y”
```
###右旋###
![GitHub](https://github.com/blacky8/Pictures/blob/master/RBTree_rotate_right.jpg)

对x进行右旋，意味着"将x变成一个右节点"。右旋的伪代码《算法导论》：
```java
RIGHT-ROTATE(T, y)  
 x ← left[y]             // 前提：这里假设y的左孩子为x。下面开始正式操作
 left[y] ← right[x]      // 将 “x的右孩子” 设为 “y的左孩子”，即 将β设为y的左孩子
 p[right[x]] ← y         // 将 “y” 设为 “x的右孩子的父亲”，即 将β的父亲设为y
 p[x] ← p[y]             // 将 “y的父亲” 设为 “x的父亲”
 if p[y] = nil[T]       
 then root[T] ← x                 // 情况1：如果 “y的父亲” 是空节点，则将x设为根节点
 else if y = right[p[y]]  
           then right[p[y]] ← x   // 情况2：如果 y是它父节点的右孩子，则将x设为“y的父节点的左孩子”
           else left[p[y]] ← x    // 情况3：(y是它父节点的左孩子) 将x设为“y的父节点的左孩子”
 right[x] ← y            // 将 “y” 设为 “x的右孩子”
 p[y] ← x                // 将 “y的父节点” 设为 “x”
 ```
**旋转总结：**

    1. 无论是左旋还是右旋，被旋转的树，在旋转前是二叉查找树，并且旋转之后仍然是一颗二叉查找树。
    2. 左旋中的“左”，意味着“被旋转的节点将变成一个左节点”。
    3. 右旋中的“右”，意味着“被旋转的节点将变成一个右节点”。

###添加节点###
<br>将一个节点插入到红黑树中，需要执行的步骤：

    1. 将红黑树当作一颗二叉查找树，将节点插入，这和"向常规二叉查找树中插入节点的方法是一样的"。
        (1)以根节点当前节点开始搜索。
        (2)拿新节点值和当前节点的值比较。
            若新节点的值更大，则以当前节点的右子节点作为新的当前节点；
            若新节点的值更小，则以当前节点的左子节点作为新的当前节点。
        (3)重复步骤(2)直到搜索到合适的叶子节点，将新节点添加为该叶子节点的子节点；
            若新节点更大，则添加为右子节点；否则添加为左子节点。
    2. 将节点着色为红色
    3. 通过旋转和重新着色等方法来修正，使之重新成为一颗红黑树

添加节点操作的伪代码《算法导论》：
```java
RB-INSERT(T, z)  
 y ← nil[T]                        // 新建节点“y”，将y设为空节点。
 x ← root[T]                       // 设“红黑树T”的根节点为“x”
 while x ≠ nil[T]                  // 找出要插入的节点“z”在二叉树T中的位置“y”
     do y ← x                      
        if key[z] < key[x]  
           then x ← left[x]  
           else x ← right[x]  
 p[z] ← y                          // 设置 “z的父亲” 为 “y”
 if y = nil[T]                     
    then root[T] ← z               // 情况1：若y是空节点，则将z设为根
    else if key[z] < key[y]        
            then left[y] ← z       // 情况2：若“z所包含的值” < “y所包含的值”，则将z设为“y的左孩子”
            else right[y] ← z      // 情况3：(“z所包含的值” >= “y所包含的值”)将z设为“y的右孩子” 
 left[z] ← nil[T]                  // z的左孩子设为空
 right[z] ← nil[T]                 // z的右孩子设为空。至此，已经完成将“节点z插入到二叉树”中了。
 color[z] ← RED                    // 将z着色为“红色”
 RB-INSERT-FIXUP(T, z)             // 通过RB-INSERT-FIXUP对红黑树的节点进行颜色修改以及旋转，让树T仍然是一颗红黑树
 ```
添加节点修正操作的伪代码《算法导论》：
```java
RB-INSERT-FIXUP(T, z)
while color[p[z]] = RED                                                  // 若“当前节点(z)的父节点是红色”，则进行以下处理。
    do if p[z] = left[p[p[z]]]                                           // 若“z的父节点”是“z的祖父节点的左孩子”，则进行以下处理。
          then y ← right[p[p[z]]]                                        // 将y设置为“z的叔叔节点(z的祖父节点的右孩子)”
               if color[y] = RED                                         // Case 1条件：叔叔是红色
                  then color[p[z]] ← BLACK                    > Case 1   //  (01) 将“父节点”设为黑色。
                       color[y] ← BLACK                       > Case 1   //  (02) 将“叔叔节点”设为黑色。
                       color[p[p[z]]] ← RED                   > Case 1   //  (03) 将“祖父节点”设为“红色”。
                       z ← p[p[z]]                            > Case 1   //  (04) 将“祖父节点”设为“当前节点”(红色节点)
                  else if z = right[p[z]]                                // Case 2条件：叔叔是黑色，且当前节点是右孩子
                          then z ← p[z]                       > Case 2   //  (01) 将“父节点”作为“新的当前节点”。
                               LEFT-ROTATE(T, z)              > Case 2   //  (02) 以“新的当前节点”为支点进行左旋。
                          color[p[z]] ← BLACK                 > Case 3   // Case 3条件：叔叔是黑色，且当前节点是左孩子。(01) 将“父节点”设为“黑色”。
                          color[p[p[z]]] ← RED                > Case 3   //  (02) 将“祖父节点”设为“红色”。
                          RIGHT-ROTATE(T, p[p[z]])            > Case 3   //  (03) 以“祖父节点”为支点进行右旋。
       else (same as then clause with "right" and "left" exchanged)      // 若“z的父节点”是“z的祖父节点的右孩子”，将上面的操作中“right”和“left”交换位置，然后依次执行。
color[root[T]] ← BLACK
``` 
下面对于插入节点后红黑树的调整策略进行详细说明
<br>**RB-INSERT-FIXUP的核心思路都是：将红色的节点移到根节点；然后，将根节点设为黑色。**
<br>根据被插入节点的父节点的情况，可以将"当前节点z被着色为红色节点，并插入二叉树"划分为三种情况来处理。

    1. 被插入的节点是根节点。
        处理方法：直接把此节点涂为黑色。
    2. 被插入的节点的父节点是黑色。
        处理方法：什么也不需要做。节点被插入后，仍然是红黑树。
    3. 被插入的节点的父节点是红色。
        处理方法：该情况与红黑树的“特性(5)”相冲突。这种情况下，被插入节点是一定存在非空祖父节点的；
        进一步的讲，被插入节点也一定存在叔叔节点(即使叔叔节点为空，我们也视之为存在，空节点本身就是黑色节点)。
        理解这点之后，我们依据"叔叔节点的情况"，将这种情况进一步划分为3种情况。
   
<br>为了便于说明，我们假设当前节点为N，其父节点为P，祖父节点为G，叔叔节点为U

    情况1：P是红色，且U也是红色，处理策略：
    1. 将P设为黑色。
    2. 将U设为黑色。
    3. 将G设为“红色”。
    4. 将G设为“当前节点”(红色节点)，之后继续对“当前节点”进行操作。
![GitHub](https://github.com/blacky8/Pictures/blob/master/RBTree_insert_case1.png)

    情况2：P是红色，U是黑色，且N为P的右孩子，处理策略：
    1. 将P作为“新的当前节点”。
    2. 以“新的当前节点”为支点进行左旋。
![GitHub](https://github.com/blacky8/Pictures/blob/master/RBTree_insert_case2.png)

    情况3：P是红色，U是黑色，且N为P的左孩子，处理策略：	
    1. 将P设为“黑色”。
    2. 将G设为“红色”。
    3. 以G为支点进行右旋。  
![GitHub](https://github.com/blacky8/Pictures/blob/master/RBTree_insert_case3.png)
	
**注意：**
<br>对于情况2和3，我们假定P是G的左子节点。如果它是右子节点，情形2和3中的左和右应当对调。
 
###删除节点###
将红黑树内的某一个节点删除，需要执行的步骤：

    1.将红黑树当作一颗二叉查找树，将节点删除
        这和"删除常规二叉查找树中删除节点的方法是一样的"。分3种情况：
        (1)被删除节点没有儿子，即为叶节点。那么，直接将该节点删除就OK了。
        (2)被删除节点只有一个儿子。那么，直接删除该节点，并用该节点的唯一子节点顶替它的位置。
        (3)被删除节点有两个儿子。那么，先找出它的后继节点；然后把“它的后继节点的内容”复制给“该节点的内容”；最后删除“它的后继节点”。
        在这里，后继节点相当于替身，在将后继节点的内容复制给"被删除节点"之后，再将后继节点删除。
        这样就巧妙的将问题转换为"删除后继节点"的情况了，下面就考虑后继节点。 
        在"被删除节点"有两个非空子节点的情况下，它的后继节点不可能是双子非空的。
        既然"后继节点"不可能双子都非空，就意味着"后继节点"要么没有儿子，要么只有一个儿子。
        若没有儿子，则按"情况① "进行处理；若只有一个儿子，则按"情况② "进行处理。
    2.通过"旋转和重新着色"等一系列来修正该树，使之重新成为一棵红黑树

删除节点操作的伪代码《算法导论》：
```java
RB-DELETE(T, z)
if left[z] = nil[T] or right[z] = nil[T]         
   then y ← z                                  // 若“z的左孩子” 或 “z的右孩子”为空，则将“z”赋值给 “y”；
   else y ← TREE-SUCCESSOR(z)                  // 否则，将“z的后继节点”赋值给 “y”。
if left[y] ≠ nil[T]
   then x ← left[y]                            // 若“y的左孩子” 不为空，则将“y的左孩子” 赋值给 “x”；
   else x ← right[y]                           // 否则，“y的右孩子” 赋值给 “x”。
p[x] ← p[y]                                    // 将“y的父节点” 设置为 “x的父节点”
if p[y] = nil[T]                               
   then root[T] ← x                            // 情况1：若“y的父节点” 为空，则设置“x” 为 “根节点”。
   else if y = left[p[y]]                    
           then left[p[y]] ← x                 // 情况2：若“y是它父节点的左孩子”，则设置“x” 为 “y的父节点的左孩子”
           else right[p[y]] ← x                // 情况3：若“y是它父节点的右孩子”，则设置“x” 为 “y的父节点的右孩子”
if y ≠ z                                    
   then key[z] ← key[y]                        // 若“y的值” 赋值给 “z”。注意：这里只拷贝z的值给y，而没有拷贝z的颜色！！！
        copy y's satellite data into z         
if color[y] = BLACK                            
   then RB-DELETE-FIXUP(T, x)                  // 若“y为黑节点”，则调用
return y
```
删除节点后修正操作的伪代码《算法导论》
```java
RB-DELETE-FIXUP(T, x)
while x ≠ root[T] and color[x] = BLACK  
    do if x = left[p[x]]      
          then w ← right[p[x]]                                             // 若 “x”是“它父节点的左孩子”，则设置 “w”为“x的叔叔”(即x为它父节点的右孩子)                                          
               if color[w] = RED                                           // Case 1: x是“黑+黑”节点，x的兄弟节点是红色。(此时x的父节点和x的兄弟节点的子节点都是黑节点)。
                  then color[w] ← BLACK                        >  Case 1   //   (01) 将x的兄弟节点设为“黑色”。
                       color[p[x]] ← RED                       >  Case 1   //   (02) 将x的父节点设为“红色”。
                       LEFT-ROTATE(T, p[x])                    >  Case 1   //   (03) 对x的父节点进行左旋。
                       w ← right[p[x]]                         >  Case 1   //   (04) 左旋后，重新设置x的兄弟节点。
               if color[left[w]] = BLACK and color[right[w]] = BLACK       // Case 2: x是“黑+黑”节点，x的兄弟节点是黑色，x的兄弟节点的两个孩子都是黑色。
                  then color[w] ← RED                          >  Case 2   //   (01) 将x的兄弟节点设为“红色”。
                       x ←  p[x]                               >  Case 2   //   (02) 设置“x的父节点”为“新的x节点”。
                  else if color[right[w]] = BLACK                          // Case 3: x是“黑+黑”节点，x的兄弟节点是黑色；x的兄弟节点的左孩子是红色，右孩子是黑色的。
                          then color[left[w]] ← BLACK          >  Case 3   //   (01) 将x兄弟节点的左孩子设为“黑色”。
                               color[w] ← RED                  >  Case 3   //   (02) 将x兄弟节点设为“红色”。
                               RIGHT-ROTATE(T, w)              >  Case 3   //   (03) 对x的兄弟节点进行右旋。
                               w ← right[p[x]]                 >  Case 3   //   (04) 右旋后，重新设置x的兄弟节点。
                        color[w] ← color[p[x]]                 >  Case 4   // Case 4: x是“黑+黑”节点，x的兄弟节点是黑色；x的兄弟节点的右孩子是红色的。(01) 将x父节点颜色 赋值给 x的兄弟节点。
                        color[p[x]] ← BLACK                    >  Case 4   //   (02) 将x父节点设为“黑色”。
                        color[right[w]] ← BLACK                >  Case 4   //   (03) 将x兄弟节点的右子节设为“黑色”。
                        LEFT-ROTATE(T, p[x])                   >  Case 4   //   (04) 对x的父节点进行左旋。
                        x ← root[T]                            >  Case 4   //   (05) 设置“x”为“根节点”。
       else (same as then clause with "right" and "left" exchanged)        // 若 “x”是“它父节点的右孩子”，将上面的操作中“right”和“left”交换位置，然后依次执行。
color[x] ← BLACK
```
<br>下面对于删除节点后红黑树的调整策略进行详细说明
<br>**RB-DELETE-FIXUP的思想是：将删除节点的儿子节点所包含的黑色不断沿树上移(向根方向移动)**
<br>由于前面的二叉查找树删除操作，我们已经把删除节点有两个非空儿子的删除情况转换为删除其后继节点（不可能双子非空）的情况
<br>所以根据被删除节点的儿子节点的情况，可以划分为三种情况来处理。

    1. 删除节点的儿子节点是红色。
        处理方法：直接把删除节点的儿子节点设为黑色。此时红黑树性质全部恢复。
    2. 删除节点的儿子节点是黑色，且是根节点。
        处理方法：什么都不做，结束。此时红黑树性质全部恢复。
    3. 删除节点的儿子节点是黑色，且不是根。
        处理方法：这种情况又可以划分为4种子情况来处理

<br>为了便于说明，我们假设要删除节点的儿子节点为N，其父节点为P，兄弟节点为S，兄弟节点的左子节点为SL，兄弟节点的右子节点为SR

    情况1：N是黑色，S是红色(此时P和SL,SR都是黑节点)，处理策略：
    1. 将S设为黑色。
    2. 将P设为红色。
    3. 对P进行左旋。
    4. 左旋后，重新设置N的兄弟节点。
![GitHub](https://github.com/blacky8/Pictures/blob/master/RBTree_delete_case1.png)

    情况2：N是黑色，S是黑色，SL,SR都是黑色，处理策略：
    1. 将S设为红色。
    2. 设置P为“新的N节点”。
![GitHub](https://github.com/blacky8/Pictures/blob/master/RBTree_delete_case2.png)

    情况3：N是黑色，S是黑色，SL是红色，SR是黑色，处理策略：
    1. 将SL为黑色。
    2. 将S设为红色。
    3. 对S进行右旋。
    4. 右旋后，重新设置N的兄弟节点。
![GitHub](https://github.com/blacky8/Pictures/blob/master/RBTree_delete_case3.png)

    情况4：N是黑色，S是黑色；SR是红色的，SL为任意颜色，处理策略：
    1. 将P颜色赋值给S。
    2. 将P设为黑色。
    3. 将SR设为黑色。
    4. 对P进行左旋。
    5. 设置N为“根节点”。
![GitHub](https://github.com/blacky8/Pictures/blob/master/RBTree_delete_case4.png)
	
###红黑树应用-TreeMap###
TreeMap和TreeSet是Java Collection Framework 的两个重要成员。
TreeMap是Map接口的常用实现类,TreeSet是Set接口的常用实现类。
TreeSet底层是通过TreeMap来实现的，因此二者的实现方式完全一样, TreeMap 的实现就是红黑树算法。

####TreeMap和TreeSet之间的关系####
为了明确两者之间的关系，先来看看TreeSet类的部分源代码：
````java
public class TreeSet<E> extends AbstractSet<E> implements NavigableSet<E>, Cloneable, java.io.Serializable 
{ 
  // 使用 NavigableMap 的 key 来保存 Set 集合的元素
  private transient NavigableMap<E,Object> m; 
  // 使用一个 PRESENT 作为 Map 集合的所有 value。
  private static final Object PRESENT = new Object(); 
  // 包访问权限的构造器，以指定的 NavigableMap 对象创建 Set 集合
  TreeSet(NavigableMap<E,Object> m) 
  { 
      this.m = m; 
  } 
  public TreeSet()                                      // ①
  { 
      // 以自然排序方式创建一个新的 TreeMap，
      // 根据该 TreeSet 创建一个 TreeSet，
      // 使用该 TreeMap 的 key 来保存 Set 集合的元素
      this(new TreeMap<E,Object>()); 
  } 
  public TreeSet(Comparator<? super E> comparator)     // ②
  { 
      // 以定制排序方式创建一个新的 TreeMap，
      // 根据该 TreeSet 创建一个 TreeSet，
      // 使用该 TreeMap 的 key 来保存 Set 集合的元素
      this(new TreeMap<E,Object>(comparator)); 
  } 
  public TreeSet(Collection<? extends E> c) 
  { 
      // 调用①号构造器创建一个 TreeSet，底层以 TreeMap 保存集合元素
      this(); 
      // 向 TreeSet 中添加 Collection 集合 c 里的所有元素
      addAll(c); 
  } 
  public TreeSet(SortedSet<E> s) 
  { 
      // 调用②号构造器创建一个 TreeSet，底层以 TreeMap 保存集合元素
      this(s.comparator()); 
      // 向 TreeSet 中添加 SortedSet 集合 s 里的所有元素
      addAll(s); 
  } 
  //TreeSet 的其他方法都只是直接调用 TreeMap 的方法来提供实现
  ... 
  public boolean addAll(Collection<? extends E> c) 
  { 
      if (m.size() == 0 && c.size() > 0 && 
          c instanceof SortedSet && 
          m instanceof TreeMap) 
      { 
          // 把 c 集合强制转换为 SortedSet 集合
          SortedSet<? extends E> set = (SortedSet<? extends E>) c; 
          // 把 m 集合强制转换为 TreeMap 集合
          TreeMap<E,Object> map = (TreeMap<E, Object>) m; 
          Comparator<? super E> cc = (Comparator<? super E>) set.comparator(); 
          Comparator<? super E> mc = map.comparator(); 
          // 如果 cc 和 mc 两个 Comparator 相等
          if (cc == mc || (cc != null && cc.equals(mc))) 
          { 
              // 把 Collection 中所有元素添加成 TreeMap 集合的 key 
              map.addAllForTreeSet(set, PRESENT); 
              return true; 
          } 
      } 
      // 直接调用父类的 addAll() 方法来实现
      return super.addAll(c); 
  } 
  ... 
}
````
从上面代码可以看出，TreeSet的①号、②号构造器的都是新建一个TreeMap作为实际存储Set元素的容器，而另外2个构造器则分别依赖于①号和②号构造器
由此可见，TreeSet底层实际使用的存储容器就是TreeMap。和HashSet完全类似的是，TreeSet里绝大部分方法都是直接调用TreeMap的方法来实现的。

对TreeMap而言，它采用“红黑树”来保存Map中每个Entry —— 每个Entry都被当成“红黑树”的一个节点对待。下面通过源码来说明TreeMap对于节点的添加，删除，检索

####TreeMap 添加节点####
put(K key, V value) 方法实现了将 Entry 放入排序二叉树中，下面是该方法的源代码：
````java
public V put(K key, V value) 
{ 
  // 先以 t 保存链表的 root 节点
  Entry<K,V> t = root; 
  // 如果 t==null，表明是一个空链表，即该 TreeMap 里没有任何 Entry 
  if (t == null) 
  { 
      // 将新的 key-value 创建一个 Entry，并将该 Entry 作为 root 
      root = new Entry<K,V>(key, value, null); 
      // 设置该 Map 集合的 size 为 1，代表包含一个 Entry 
      size = 1; 
      // 记录修改次数为 1 
      modCount++; 
      return null; 
  } 
  int cmp; 
  Entry<K,V> parent; 
  Comparator<? super K> cpr = comparator; 
  // 如果比较器 cpr 不为 null，即表明采用定制排序
  if (cpr != null) 
  { 
      do { 
          // 使用 parent 上次循环后的 t 所引用的 Entry 
          parent = t; 
          // 拿新插入 key 和 t 的 key 进行比较
          cmp = cpr.compare(key, t.key); 
          // 如果新插入的 key 小于 t 的 key，t 等于 t 的左边节点
          if (cmp < 0) 
              t = t.left; 
          // 如果新插入的 key 大于 t 的 key，t 等于 t 的右边节点
          else if (cmp > 0) 
              t = t.right; 
          // 如果两个 key 相等，新的 value 覆盖原有的 value，
          // 并返回原有的 value 
          else 
              return t.setValue(value); 
      } while (t != null); 
  } 
  else 
  { 
      if (key == null) 
          throw new NullPointerException(); 
      Comparable<? super K> k = (Comparable<? super K>) key; 
      do { 
          // 使用 parent 上次循环后的 t 所引用的 Entry 
          parent = t; 
          // 拿新插入 key 和 t 的 key 进行比较
          cmp = k.compareTo(t.key); 
          // 如果新插入的 key 小于 t 的 key，t 等于 t 的左边节点
          if (cmp < 0) 
              t = t.left; 
          // 如果新插入的 key 大于 t 的 key，t 等于 t 的右边节点
          else if (cmp > 0) 
              t = t.right; 
          // 如果两个 key 相等，新的 value 覆盖原有的 value，
          // 并返回原有的 value 
          else 
              return t.setValue(value); 
      } while (t != null); 
  } 
  // 将新插入的节点作为 parent 节点的子节点
  Entry<K,V> e = new Entry<K,V>(key, value, parent); 
  // 如果新插入 key 小于 parent 的 key，则 e 作为 parent 的左子节点
  if (cmp < 0) 
      parent.left = e; 
  // 如果新插入 key 小于 parent 的 key，则 e 作为 parent 的右子节点
  else 
      parent.right = e; 
  // 修复红黑树
  fixAfterInsertion(e);                                
  size++; 
  modCount++; 
  return null; 
}
````
添加节点后的修复操作由 fixAfterInsertion(Entry<K,V> x) 方法提供，该方法的源代码如下：
````java
private void fixAfterInsertion(Entry<K,V> x) 
{ 
  x.color = RED; 
  // 直到 x 节点的父节点不是根，且 x 的父节点不是红色
  while (x != null && x != root 
      && x.parent.color == RED) 
  { 
      // 如果 x 的父节点是其父节点的左子节点
      if (parentOf(x) == leftOf(parentOf(parentOf(x)))) 
      { 
          // 获取 x 的父节点的兄弟节点
          Entry<K,V> y = rightOf(parentOf(parentOf(x))); 
          // 如果 x 的父节点的兄弟节点是红色
          if (colorOf(y) == RED) 
          { 
              // 将 x 的父节点设为黑色
              setColor(parentOf(x), BLACK); 
              // 将 x 的父节点的兄弟节点设为黑色
              setColor(y, BLACK); 
              // 将 x 的父节点的父节点设为红色
              setColor(parentOf(parentOf(x)), RED); 
              x = parentOf(parentOf(x)); 
          } 
          // 如果 x 的父节点的兄弟节点是黑色
          else 
          { 
              // 如果 x 是其父节点的右子节点
              if (x == rightOf(parentOf(x))) 
              { 
                  // 将 x 的父节点设为 x 
                  x = parentOf(x); 
                  rotateLeft(x); 
              } 
              // 把 x 的父节点设为黑色
              setColor(parentOf(x), BLACK); 
              // 把 x 的父节点的父节点设为红色
              setColor(parentOf(parentOf(x)), RED); 
              rotateRight(parentOf(parentOf(x))); 
          } 
      } 
      // 如果 x 的父节点是其父节点的右子节点
      else 
      { 
          // 获取 x 的父节点的兄弟节点
          Entry<K,V> y = leftOf(parentOf(parentOf(x))); 
          // 如果 x 的父节点的兄弟节点是红色
          if (colorOf(y) == RED) 
          { 
              // 将 x 的父节点设为黑色。
              setColor(parentOf(x), BLACK); 
              // 将 x 的父节点的兄弟节点设为黑色
              setColor(y, BLACK); 
              // 将 x 的父节点的父节点设为红色
              setColor(parentOf(parentOf(x)), RED); 
              // 将 x 设为 x 的父节点的节点
              x = parentOf(parentOf(x)); 
          } 
          // 如果 x 的父节点的兄弟节点是黑色
          else 
          { 
              // 如果 x 是其父节点的左子节点
              if (x == leftOf(parentOf(x))) 
              { 
                  // 将 x 的父节点设为 x 
                  x = parentOf(x); 
                  rotateRight(x); 
              } 
              // 把 x 的父节点设为黑色
              setColor(parentOf(x), BLACK); 
              // 把 x 的父节点的父节点设为红色
              setColor(parentOf(parentOf(x)), RED); 
              rotateLeft(parentOf(parentOf(x))); 
          } 
      } 
  } 
  // 将根节点设为黑色
  root.color = BLACK; 
}
````  
####TreeMap 删除节点####
TreeMap删除节点时，采用被删除节点的右子树中最小节点与被删节点交换的方式进行维护。
deleteEntry(Entry<K,V> p) 方法实现了将 Entry 从排序二叉树中删除，下面是该方法的源代码：
````java
private void deleteEntry(Entry<K,V> p) 
 { 
    modCount++; 
    size--; 
    // 如果被删除节点的左子树、右子树都不为空
    if (p.left != null && p.right != null) 
    { 
        // 用 p 节点的中序后继节点代替 p 节点
        Entry<K,V> s = successor (p); 
        p.key = s.key; 
        p.value = s.value; 
        p = s; 
    } 
    // 如果 p 节点的左节点存在，replacement 代表左节点；否则代表右节点。
    Entry<K,V> replacement = (p.left != null ? p.left : p.right); 
    if (replacement != null) 
    { 
        replacement.parent = p.parent; 
        // 如果 p 没有父节点，则 replacemment 变成父节点
        if (p.parent == null) 
            root = replacement; 
        // 如果 p 节点是其父节点的左子节点
        else if (p == p.parent.left) 
            p.parent.left  = replacement; 
        // 如果 p 节点是其父节点的右子节点
        else 
            p.parent.right = replacement; 
        p.left = p.right = p.parent = null; 
        // 修复红黑树
        if (p.color == BLACK) 
            fixAfterDeletion(replacement);       
    } 
    // 如果 p 节点没有父节点
    else if (p.parent == null) 
    { 
        root = null; 
    } 
    else 
    { 
        if (p.color == BLACK) 
            // 修复红黑树
            fixAfterDeletion(p);                 
        if (p.parent != null) 
        { 
            // 如果 p 是其父节点的左子节点
            if (p == p.parent.left) 
                p.parent.left = null; 
            // 如果 p 是其父节点的右子节点
            else if (p == p.parent.right) 
                p.parent.right = null; 
            p.parent = null; 
        } 
    } 
 }
````
删除之后的修复操作由 fixAfterDeletion(Entry<K,V> x) 方法提供，该方法源代码如下：
````java
private void fixAfterDeletion(Entry<K,V> x) 
{ 
  // 直到 x 不是根节点，且 x 的颜色是黑色
  while (x != root && colorOf(x) == BLACK) 
  { 
      // 如果 x 是其父节点的左子节点
      if (x == leftOf(parentOf(x))) 
      { 
          // 获取 x 节点的兄弟节点
          Entry<K,V> sib = rightOf(parentOf(x)); 
          // 如果 sib 节点是红色
          if (colorOf(sib) == RED) 
          { 
              // 将 sib 节点设为黑色
              setColor(sib, BLACK); 
              // 将 x 的父节点设为红色
              setColor(parentOf(x), RED); 
              rotateLeft(parentOf(x)); 
              // 再次将 sib 设为 x 的父节点的右子节点
              sib = rightOf(parentOf(x)); 
          } 
          // 如果 sib 的两个子节点都是黑色
          if (colorOf(leftOf(sib)) == BLACK 
              && colorOf(rightOf(sib)) == BLACK) 
          { 
              // 将 sib 设为红色
              setColor(sib, RED); 
              // 让 x 等于 x 的父节点
              x = parentOf(x); 
          } 
          else 
          { 
              // 如果 sib 的只有右子节点是黑色
              if (colorOf(rightOf(sib)) == BLACK) 
              { 
                  // 将 sib 的左子节点也设为黑色
                  setColor(leftOf(sib), BLACK); 
                  // 将 sib 设为红色
                  setColor(sib, RED); 
                  rotateRight(sib); 
                  sib = rightOf(parentOf(x)); 
              } 
              // 设置 sib 的颜色与 x 的父节点的颜色相同
              setColor(sib, colorOf(parentOf(x))); 
              // 将 x 的父节点设为黑色
              setColor(parentOf(x), BLACK); 
              // 将 sib 的右子节点设为黑色
              setColor(rightOf(sib), BLACK); 
              rotateLeft(parentOf(x)); 
              x = root; 
          } 
      } 
      // 如果 x 是其父节点的右子节点
      else 
      { 
          // 获取 x 节点的兄弟节点
          Entry<K,V> sib = leftOf(parentOf(x)); 
          // 如果 sib 的颜色是红色
          if (colorOf(sib) == RED) 
          { 
              // 将 sib 的颜色设为黑色
              setColor(sib, BLACK); 
              // 将 sib 的父节点设为红色
              setColor(parentOf(x), RED); 
              rotateRight(parentOf(x)); 
              sib = leftOf(parentOf(x)); 
          } 
          // 如果 sib 的两个子节点都是黑色
          if (colorOf(rightOf(sib)) == BLACK 
              && colorOf(leftOf(sib)) == BLACK) 
          { 
              // 将 sib 设为红色
              setColor(sib, RED); 
              // 让 x 等于 x 的父节点
              x = parentOf(x); 
          } 
          else 
          { 
              // 如果 sib 只有左子节点是黑色
              if (colorOf(leftOf(sib)) == BLACK) 
              { 
                  // 将 sib 的右子节点也设为黑色
                  setColor(rightOf(sib), BLACK); 
                  // 将 sib 设为红色
                  setColor(sib, RED); 
                  rotateLeft(sib); 
                  sib = leftOf(parentOf(x)); 
              } 
              // 将 sib 的颜色设为与 x 的父节点颜色相同
              setColor(sib, colorOf(parentOf(x))); 
              // 将 x 的父节点设为黑色
              setColor(parentOf(x), BLACK); 
              // 将 sib 的左子节点设为黑色
              setColor(leftOf(sib), BLACK); 
              rotateRight(parentOf(x)); 
              x = root; 
          } 
      } 
  } 
  setColor(x, BLACK); 
}
````
####检索节点####
当TreeMap根据key来取出value时，TreeMap对应的方法如下：
````java
public V get(Object key) 
{ 
  // 根据指定 key 取出对应的 Entry 
  Entry>K,V< p = getEntry(key); 
  // 返回该 Entry 所包含的 value 
  return (p==null ? null : p.value); 
}
````
从上面程序的粗体字代码可以看出，get(Object key) 方法实质是由于 getEntry() 方法实现的，这个 getEntry() 方法的代码如下：
````java
 final Entry<K,V> getEntry(Object key) 
 { 
    // 如果 comparator 不为 null，表明程序采用定制排序
    if (comparator != null) 
        // 调用 getEntryUsingComparator 方法来取出对应的 key 
        return getEntryUsingComparator(key); 
    // 如果 key 形参的值为 null，抛出 NullPointerException 异常
    if (key == null) 
        throw new NullPointerException(); 
    // 将 key 强制类型转换为 Comparable 实例
    Comparable<? super K> k = (Comparable<? super K>) key; 
    // 从树的根节点开始
    Entry<K,V> p = root; 
    while (p != null) 
    { 
        // 拿 key 与当前节点的 key 进行比较
        int cmp = k.compareTo(p.key); 
        // 如果 key 小于当前节点的 key，向“左子树”搜索
        if (cmp < 0) 
            p = p.left; 
        // 如果 key 大于当前节点的 key，向“右子树”搜索
        else if (cmp > 0) 
            p = p.right; 
        // 不大于、不小于，就是找到了目标 Entry 
        else 
            return p; 
    } 
    return null; 
 }
 ````
上面的 getEntry(Object obj) 方法也是充分利用排序二叉树的特征来搜索目标 Entry。
程序依然从二叉树的根节点开始，如果被搜索节点大于当前节点，程序向“右子树”搜索；如果被搜索节点小于当前节点，程序向“左子树”搜索；如果相等，那就是找到了指定节点。
当 TreeMap 里的 comparator != null 即表明该 TreeMap 采用了定制排序，在采用定制排序的方式下，TreeMap 采用 getEntryUsingComparator(key) 方法来根据 key 获取 Entry。下面是该方法的代码：
````java
final Entry<K,V> getEntryUsingComparator(Object key) 
{ 
  K k = (K) key; 
  // 获取该 TreeMap 的 comparator 
  Comparator<? super K> cpr = comparator; 
  if (cpr != null) 
  { 
      // 从根节点开始
      Entry<K,V> p = root; 
      while (p != null) 
      { 
          // 拿 key 与当前节点的 key 进行比较
          int cmp = cpr.compare(k, p.key); 
          // 如果 key 小于当前节点的 key，向“左子树”搜索
          if (cmp < 0) 
              p = p.left; 
          // 如果 key 大于当前节点的 key，向“右子树”搜索
          else if (cmp > 0) 
              p = p.right; 
          // 不大于、不小于，就是找到了目标 Entry 
          else 
              return p; 
      } 
  } 
  return null; 
}
````
其实 getEntry、getEntryUsingComparator 两个方法的实现思路完全类似，只是前者对自然排序的 TreeMap 获取有效，后者对定制排序的 TreeMap 有效。
通过上面源代码的分析不难看出，TreeMap 这个工具类的实现其实很简单。从内部结构来看，TreeMap 本质上就是一棵“红黑树”，而 TreeMap 的每个 Entry 就是该红黑树的一个节点。

参考文献：
<br>http://www.cnblogs.com/skywang12345/p/3245399.html
<br>http://www.ibm.com/developerworks/cn/java/j-lo-tree/
<br>http://blog.csdn.net/v_JULY_v/article/details/6109153