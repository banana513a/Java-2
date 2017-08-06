#ǳ̸�������TreeMap�㷨ʵ��#
R-B Tree��ȫ����Red-Black Tree���ֳ�Ϊ�������������һ������Ķ����������
�������ÿ���ڵ��϶��д洢λ��ʾ�ڵ����ɫ�������Ǻ�(Red)���(Black)��

�������Ӧ�ñȽϹ㷺����Ҫ���������洢��������ݣ�����ʱ�临�Ӷ���O(lgn)��Ч�ʷǳ�֮�ߡ�
���磬Java�����е�TreeSet��TreeMap��C++ STL�е�set��map���Լ�Linux�����ڴ�Ĺ�������ͨ�������ȥʵ�ֵġ�

**�����������**

    1. ÿ���ڵ�����Ǻ�ɫ�������Ǻ�ɫ��
    2. ���ڵ��Ǻ�ɫ��
    3. ÿ��Ҷ�ӽڵ㣨NIL���Ǻ�ɫ�� [ע�⣺����Ҷ�ӽڵ㣬��ָΪ��(NIL��NULL)��Ҷ�ӽڵ㣡]
    4. ���һ���ڵ��Ǻ�ɫ�ģ��������ӽڵ�����Ǻ�ɫ�ġ�
    5. ��һ���ڵ㵽�ýڵ������ڵ������·���ϰ�����ͬ��Ŀ�ĺڽڵ㡣

**ע�⣺**

    1. ����3�е�Ҷ�ӽڵ㣬��ֻΪ��(NIL��null)�Ľڵ㡣
    2. ����5��ȷ��û��һ��·���������·����������������������������ǽӽ�ƽ��Ķ�������

�����ʾ��ͼ���£�
![GitHub](https://github.com/blacky8/Pictures/blob/master/RBTree.jpg)

##������Ļ�������##
###����###
![GitHub](https://github.com/blacky8/Pictures/blob/master/RBTree_rotate_left.jpg)

��x������������ζ��"��x���һ����ڵ�"��������α���롶�㷨���ۡ���
```java
LEFT-ROTATE(T, x)  
 y �� right[x]            // ǰ�᣺�������x���Һ���Ϊy�����濪ʼ��ʽ����
 right[x] �� left[y]      // �� ��y�����ӡ� ��Ϊ ��x���Һ��ӡ����� ������Ϊx���Һ���
 p[left[y]] �� x          // �� ��x�� ��Ϊ ��y�����ӵĸ��ס����� ���µĸ�����Ϊx
 p[y] �� p[x]             // �� ��x�ĸ��ס� ��Ϊ ��y�ĸ��ס�
 if p[x] = nil[T]       
 then root[T] �� y                 // ���1����� ��x�ĸ��ס� �ǿսڵ㣬��y��Ϊ���ڵ�
 else if x = left[p[x]]  
           then left[p[x]] �� y    // ���2����� x�������ڵ�����ӣ���y��Ϊ��x�ĸ��ڵ�����ӡ�
           else right[p[x]] �� y   // ���3��(x�������ڵ���Һ���) ��y��Ϊ��x�ĸ��ڵ���Һ��ӡ�
 left[y] �� x             // �� ��x�� ��Ϊ ��y�����ӡ�
 p[x] �� y                // �� ��x�ĸ��ڵ㡱 ��Ϊ ��y��
```
###����###
![GitHub](https://github.com/blacky8/Pictures/blob/master/RBTree_rotate_right.jpg)

��x������������ζ��"��x���һ���ҽڵ�"��������α���롶�㷨���ۡ���
```java
RIGHT-ROTATE(T, y)  
 x �� left[y]             // ǰ�᣺�������y������Ϊx�����濪ʼ��ʽ����
 left[y] �� right[x]      // �� ��x���Һ��ӡ� ��Ϊ ��y�����ӡ����� ������Ϊy������
 p[right[x]] �� y         // �� ��y�� ��Ϊ ��x���Һ��ӵĸ��ס����� ���µĸ�����Ϊy
 p[x] �� p[y]             // �� ��y�ĸ��ס� ��Ϊ ��x�ĸ��ס�
 if p[y] = nil[T]       
 then root[T] �� x                 // ���1����� ��y�ĸ��ס� �ǿսڵ㣬��x��Ϊ���ڵ�
 else if y = right[p[y]]  
           then right[p[y]] �� x   // ���2����� y�������ڵ���Һ��ӣ���x��Ϊ��y�ĸ��ڵ�����ӡ�
           else left[p[y]] �� x    // ���3��(y�������ڵ������) ��x��Ϊ��y�ĸ��ڵ�����ӡ�
 right[x] �� y            // �� ��y�� ��Ϊ ��x���Һ��ӡ�
 p[y] �� x                // �� ��y�ĸ��ڵ㡱 ��Ϊ ��x��
 ```
**��ת�ܽ᣺**

    1. ������������������������ת����������תǰ�Ƕ����������������ת֮����Ȼ��һ�Ŷ����������
    2. �����еġ��󡱣���ζ�š�����ת�Ľڵ㽫���һ����ڵ㡱��
    3. �����еġ��ҡ�����ζ�š�����ת�Ľڵ㽫���һ���ҽڵ㡱��

###��ӽڵ�###
<br>��һ���ڵ���뵽������У���Ҫִ�еĲ��裺

    1. �����������һ�Ŷ�������������ڵ���룬���"�򳣹����������в���ڵ�ķ�����һ����"��
        (1)�Ը��ڵ㵱ǰ�ڵ㿪ʼ������
        (2)���½ڵ�ֵ�͵�ǰ�ڵ��ֵ�Ƚϡ�
            ���½ڵ��ֵ�������Ե�ǰ�ڵ�����ӽڵ���Ϊ�µĵ�ǰ�ڵ㣻
            ���½ڵ��ֵ��С�����Ե�ǰ�ڵ�����ӽڵ���Ϊ�µĵ�ǰ�ڵ㡣
        (3)�ظ�����(2)ֱ�����������ʵ�Ҷ�ӽڵ㣬���½ڵ����Ϊ��Ҷ�ӽڵ���ӽڵ㣻
            ���½ڵ���������Ϊ���ӽڵ㣻�������Ϊ���ӽڵ㡣
    2. ���ڵ���ɫΪ��ɫ
    3. ͨ����ת��������ɫ�ȷ�����������ʹ֮���³�Ϊһ�ź����

��ӽڵ������α���롶�㷨���ۡ���
```java
RB-INSERT(T, z)  
 y �� nil[T]                        // �½��ڵ㡰y������y��Ϊ�սڵ㡣
 x �� root[T]                       // �衰�����T���ĸ��ڵ�Ϊ��x��
 while x �� nil[T]                  // �ҳ�Ҫ����Ľڵ㡰z���ڶ�����T�е�λ�á�y��
     do y �� x                      
        if key[z] < key[x]  
           then x �� left[x]  
           else x �� right[x]  
 p[z] �� y                          // ���� ��z�ĸ��ס� Ϊ ��y��
 if y = nil[T]                     
    then root[T] �� z               // ���1����y�ǿսڵ㣬��z��Ϊ��
    else if key[z] < key[y]        
            then left[y] �� z       // ���2������z��������ֵ�� < ��y��������ֵ������z��Ϊ��y�����ӡ�
            else right[y] �� z      // ���3��(��z��������ֵ�� >= ��y��������ֵ��)��z��Ϊ��y���Һ��ӡ� 
 left[z] �� nil[T]                  // z��������Ϊ��
 right[z] �� nil[T]                 // z���Һ�����Ϊ�ա����ˣ��Ѿ���ɽ����ڵ�z���뵽�����������ˡ�
 color[z] �� RED                    // ��z��ɫΪ����ɫ��
 RB-INSERT-FIXUP(T, z)             // ͨ��RB-INSERT-FIXUP�Ժ�����Ľڵ������ɫ�޸��Լ���ת������T��Ȼ��һ�ź����
 ```
��ӽڵ�����������α���롶�㷨���ۡ���
```java
RB-INSERT-FIXUP(T, z)
while color[p[z]] = RED                                                  // ������ǰ�ڵ�(z)�ĸ��ڵ��Ǻ�ɫ������������´���
    do if p[z] = left[p[p[z]]]                                           // ����z�ĸ��ڵ㡱�ǡ�z���游�ڵ�����ӡ�����������´���
          then y �� right[p[p[z]]]                                        // ��y����Ϊ��z������ڵ�(z���游�ڵ���Һ���)��
               if color[y] = RED                                         // Case 1�����������Ǻ�ɫ
                  then color[p[z]] �� BLACK                    > Case 1   //  (01) �������ڵ㡱��Ϊ��ɫ��
                       color[y] �� BLACK                       > Case 1   //  (02) ��������ڵ㡱��Ϊ��ɫ��
                       color[p[p[z]]] �� RED                   > Case 1   //  (03) �����游�ڵ㡱��Ϊ����ɫ����
                       z �� p[p[z]]                            > Case 1   //  (04) �����游�ڵ㡱��Ϊ����ǰ�ڵ㡱(��ɫ�ڵ�)
                  else if z = right[p[z]]                                // Case 2�����������Ǻ�ɫ���ҵ�ǰ�ڵ����Һ���
                          then z �� p[z]                       > Case 2   //  (01) �������ڵ㡱��Ϊ���µĵ�ǰ�ڵ㡱��
                               LEFT-ROTATE(T, z)              > Case 2   //  (02) �ԡ��µĵ�ǰ�ڵ㡱Ϊ֧�����������
                          color[p[z]] �� BLACK                 > Case 3   // Case 3�����������Ǻ�ɫ���ҵ�ǰ�ڵ������ӡ�(01) �������ڵ㡱��Ϊ����ɫ����
                          color[p[p[z]]] �� RED                > Case 3   //  (02) �����游�ڵ㡱��Ϊ����ɫ����
                          RIGHT-ROTATE(T, p[p[z]])            > Case 3   //  (03) �ԡ��游�ڵ㡱Ϊ֧�����������
       else (same as then clause with "right" and "left" exchanged)      // ����z�ĸ��ڵ㡱�ǡ�z���游�ڵ���Һ��ӡ���������Ĳ����С�right���͡�left������λ�ã�Ȼ������ִ�С�
color[root[T]] �� BLACK
``` 
������ڲ���ڵ�������ĵ������Խ�����ϸ˵��
<br>**RB-INSERT-FIXUP�ĺ���˼·���ǣ�����ɫ�Ľڵ��Ƶ����ڵ㣻Ȼ�󣬽����ڵ���Ϊ��ɫ��**
<br>���ݱ�����ڵ�ĸ��ڵ����������Խ�"��ǰ�ڵ�z����ɫΪ��ɫ�ڵ㣬�����������"����Ϊ�������������

    1. ������Ľڵ��Ǹ��ڵ㡣
        ��������ֱ�ӰѴ˽ڵ�ͿΪ��ɫ��
    2. ������Ľڵ�ĸ��ڵ��Ǻ�ɫ��
        ��������ʲôҲ����Ҫ�����ڵ㱻�������Ȼ�Ǻ������
    3. ������Ľڵ�ĸ��ڵ��Ǻ�ɫ��
        ��������������������ġ�����(5)�����ͻ����������£�������ڵ���һ�����ڷǿ��游�ڵ�ģ�
        ��һ���Ľ���������ڵ�Ҳһ����������ڵ�(��ʹ����ڵ�Ϊ�գ�����Ҳ��֮Ϊ���ڣ��սڵ㱾����Ǻ�ɫ�ڵ�)��
        ������֮����������"����ڵ�����"�������������һ������Ϊ3�������
   
<br>Ϊ�˱���˵�������Ǽ��赱ǰ�ڵ�ΪN���丸�ڵ�ΪP���游�ڵ�ΪG������ڵ�ΪU

    ���1��P�Ǻ�ɫ����UҲ�Ǻ�ɫ��������ԣ�
    1. ��P��Ϊ��ɫ��
    2. ��U��Ϊ��ɫ��
    3. ��G��Ϊ����ɫ����
    4. ��G��Ϊ����ǰ�ڵ㡱(��ɫ�ڵ�)��֮������ԡ���ǰ�ڵ㡱���в�����
![GitHub](https://github.com/blacky8/Pictures/blob/master/RBTree_insert_case1.png)

    ���2��P�Ǻ�ɫ��U�Ǻ�ɫ����NΪP���Һ��ӣ�������ԣ�
    1. ��P��Ϊ���µĵ�ǰ�ڵ㡱��
    2. �ԡ��µĵ�ǰ�ڵ㡱Ϊ֧�����������
![GitHub](https://github.com/blacky8/Pictures/blob/master/RBTree_insert_case2.png)

    ���3��P�Ǻ�ɫ��U�Ǻ�ɫ����NΪP�����ӣ�������ԣ�	
    1. ��P��Ϊ����ɫ����
    2. ��G��Ϊ����ɫ����
    3. ��GΪ֧�����������  
![GitHub](https://github.com/blacky8/Pictures/blob/master/RBTree_insert_case3.png)
	
**ע�⣺**
<br>�������2��3�����Ǽٶ�P��G�����ӽڵ㡣����������ӽڵ㣬����2��3�е������Ӧ���Ե���
 
###ɾ���ڵ�###
��������ڵ�ĳһ���ڵ�ɾ������Ҫִ�еĲ��裺

    1.�����������һ�Ŷ�������������ڵ�ɾ��
        ���"ɾ����������������ɾ���ڵ�ķ�����һ����"����3�������
        (1)��ɾ���ڵ�û�ж��ӣ���ΪҶ�ڵ㡣��ô��ֱ�ӽ��ýڵ�ɾ����OK�ˡ�
        (2)��ɾ���ڵ�ֻ��һ�����ӡ���ô��ֱ��ɾ���ýڵ㣬���øýڵ��Ψһ�ӽڵ㶥������λ�á�
        (3)��ɾ���ڵ����������ӡ���ô�����ҳ����ĺ�̽ڵ㣻Ȼ��ѡ����ĺ�̽ڵ�����ݡ����Ƹ����ýڵ�����ݡ������ɾ�������ĺ�̽ڵ㡱��
        �������̽ڵ��൱�������ڽ���̽ڵ�����ݸ��Ƹ�"��ɾ���ڵ�"֮���ٽ���̽ڵ�ɾ����
        ����������Ľ�����ת��Ϊ"ɾ����̽ڵ�"������ˣ�����Ϳ��Ǻ�̽ڵ㡣 
        ��"��ɾ���ڵ�"�������ǿ��ӽڵ������£����ĺ�̽ڵ㲻������˫�ӷǿյġ�
        ��Ȼ"��̽ڵ�"������˫�Ӷ��ǿգ�����ζ��"��̽ڵ�"Ҫôû�ж��ӣ�Ҫôֻ��һ�����ӡ�
        ��û�ж��ӣ���"����� "���д�����ֻ��һ�����ӣ���"����� "���д���
    2.ͨ��"��ת��������ɫ"��һϵ��������������ʹ֮���³�Ϊһ�ú����

ɾ���ڵ������α���롶�㷨���ۡ���
```java
RB-DELETE(T, z)
if left[z] = nil[T] or right[z] = nil[T]         
   then y �� z                                  // ����z�����ӡ� �� ��z���Һ��ӡ�Ϊ�գ��򽫡�z����ֵ�� ��y����
   else y �� TREE-SUCCESSOR(z)                  // ���򣬽���z�ĺ�̽ڵ㡱��ֵ�� ��y����
if left[y] �� nil[T]
   then x �� left[y]                            // ����y�����ӡ� ��Ϊ�գ��򽫡�y�����ӡ� ��ֵ�� ��x����
   else x �� right[y]                           // ���򣬡�y���Һ��ӡ� ��ֵ�� ��x����
p[x] �� p[y]                                    // ����y�ĸ��ڵ㡱 ����Ϊ ��x�ĸ��ڵ㡱
if p[y] = nil[T]                               
   then root[T] �� x                            // ���1������y�ĸ��ڵ㡱 Ϊ�գ������á�x�� Ϊ �����ڵ㡱��
   else if y = left[p[y]]                    
           then left[p[y]] �� x                 // ���2������y�������ڵ�����ӡ��������á�x�� Ϊ ��y�ĸ��ڵ�����ӡ�
           else right[p[y]] �� x                // ���3������y�������ڵ���Һ��ӡ��������á�x�� Ϊ ��y�ĸ��ڵ���Һ��ӡ�
if y �� z                                    
   then key[z] �� key[y]                        // ����y��ֵ�� ��ֵ�� ��z����ע�⣺����ֻ����z��ֵ��y����û�п���z����ɫ������
        copy y's satellite data into z         
if color[y] = BLACK                            
   then RB-DELETE-FIXUP(T, x)                  // ����yΪ�ڽڵ㡱�������
return y
```
ɾ���ڵ������������α���롶�㷨���ۡ�
```java
RB-DELETE-FIXUP(T, x)
while x �� root[T] and color[x] = BLACK  
    do if x = left[p[x]]      
          then w �� right[p[x]]                                             // �� ��x���ǡ������ڵ�����ӡ��������� ��w��Ϊ��x�����塱(��xΪ�����ڵ���Һ���)                                          
               if color[w] = RED                                           // Case 1: x�ǡ���+�ڡ��ڵ㣬x���ֵܽڵ��Ǻ�ɫ��(��ʱx�ĸ��ڵ��x���ֵܽڵ���ӽڵ㶼�Ǻڽڵ�)��
                  then color[w] �� BLACK                        >  Case 1   //   (01) ��x���ֵܽڵ���Ϊ����ɫ����
                       color[p[x]] �� RED                       >  Case 1   //   (02) ��x�ĸ��ڵ���Ϊ����ɫ����
                       LEFT-ROTATE(T, p[x])                    >  Case 1   //   (03) ��x�ĸ��ڵ����������
                       w �� right[p[x]]                         >  Case 1   //   (04) ��������������x���ֵܽڵ㡣
               if color[left[w]] = BLACK and color[right[w]] = BLACK       // Case 2: x�ǡ���+�ڡ��ڵ㣬x���ֵܽڵ��Ǻ�ɫ��x���ֵܽڵ���������Ӷ��Ǻ�ɫ��
                  then color[w] �� RED                          >  Case 2   //   (01) ��x���ֵܽڵ���Ϊ����ɫ����
                       x ��  p[x]                               >  Case 2   //   (02) ���á�x�ĸ��ڵ㡱Ϊ���µ�x�ڵ㡱��
                  else if color[right[w]] = BLACK                          // Case 3: x�ǡ���+�ڡ��ڵ㣬x���ֵܽڵ��Ǻ�ɫ��x���ֵܽڵ�������Ǻ�ɫ���Һ����Ǻ�ɫ�ġ�
                          then color[left[w]] �� BLACK          >  Case 3   //   (01) ��x�ֵܽڵ��������Ϊ����ɫ����
                               color[w] �� RED                  >  Case 3   //   (02) ��x�ֵܽڵ���Ϊ����ɫ����
                               RIGHT-ROTATE(T, w)              >  Case 3   //   (03) ��x���ֵܽڵ����������
                               w �� right[p[x]]                 >  Case 3   //   (04) ��������������x���ֵܽڵ㡣
                        color[w] �� color[p[x]]                 >  Case 4   // Case 4: x�ǡ���+�ڡ��ڵ㣬x���ֵܽڵ��Ǻ�ɫ��x���ֵܽڵ���Һ����Ǻ�ɫ�ġ�(01) ��x���ڵ���ɫ ��ֵ�� x���ֵܽڵ㡣
                        color[p[x]] �� BLACK                    >  Case 4   //   (02) ��x���ڵ���Ϊ����ɫ����
                        color[right[w]] �� BLACK                >  Case 4   //   (03) ��x�ֵܽڵ�����ӽ���Ϊ����ɫ����
                        LEFT-ROTATE(T, p[x])                   >  Case 4   //   (04) ��x�ĸ��ڵ����������
                        x �� root[T]                            >  Case 4   //   (05) ���á�x��Ϊ�����ڵ㡱��
       else (same as then clause with "right" and "left" exchanged)        // �� ��x���ǡ������ڵ���Һ��ӡ���������Ĳ����С�right���͡�left������λ�ã�Ȼ������ִ�С�
color[x] �� BLACK
```
<br>�������ɾ���ڵ�������ĵ������Խ�����ϸ˵��
<br>**RB-DELETE-FIXUP��˼���ǣ���ɾ���ڵ�Ķ��ӽڵ��������ĺ�ɫ������������(��������ƶ�)**
<br>����ǰ��Ķ��������ɾ�������������Ѿ���ɾ���ڵ��������ǿն��ӵ�ɾ�����ת��Ϊɾ�����̽ڵ㣨������˫�ӷǿգ������
<br>���Ը��ݱ�ɾ���ڵ�Ķ��ӽڵ����������Ի���Ϊ�������������

    1. ɾ���ڵ�Ķ��ӽڵ��Ǻ�ɫ��
        ��������ֱ�Ӱ�ɾ���ڵ�Ķ��ӽڵ���Ϊ��ɫ����ʱ���������ȫ���ָ���
    2. ɾ���ڵ�Ķ��ӽڵ��Ǻ�ɫ�����Ǹ��ڵ㡣
        ��������ʲô����������������ʱ���������ȫ���ָ���
    3. ɾ���ڵ�Ķ��ӽڵ��Ǻ�ɫ���Ҳ��Ǹ���
        ����������������ֿ��Ի���Ϊ4�������������

<br>Ϊ�˱���˵�������Ǽ���Ҫɾ���ڵ�Ķ��ӽڵ�ΪN���丸�ڵ�ΪP���ֵܽڵ�ΪS���ֵܽڵ�����ӽڵ�ΪSL���ֵܽڵ�����ӽڵ�ΪSR

    ���1��N�Ǻ�ɫ��S�Ǻ�ɫ(��ʱP��SL,SR���Ǻڽڵ�)��������ԣ�
    1. ��S��Ϊ��ɫ��
    2. ��P��Ϊ��ɫ��
    3. ��P����������
    4. ��������������N���ֵܽڵ㡣
![GitHub](https://github.com/blacky8/Pictures/blob/master/RBTree_delete_case1.png)

    ���2��N�Ǻ�ɫ��S�Ǻ�ɫ��SL,SR���Ǻ�ɫ��������ԣ�
    1. ��S��Ϊ��ɫ��
    2. ����PΪ���µ�N�ڵ㡱��
![GitHub](https://github.com/blacky8/Pictures/blob/master/RBTree_delete_case2.png)

    ���3��N�Ǻ�ɫ��S�Ǻ�ɫ��SL�Ǻ�ɫ��SR�Ǻ�ɫ��������ԣ�
    1. ��SLΪ��ɫ��
    2. ��S��Ϊ��ɫ��
    3. ��S����������
    4. ��������������N���ֵܽڵ㡣
![GitHub](https://github.com/blacky8/Pictures/blob/master/RBTree_delete_case3.png)

    ���4��N�Ǻ�ɫ��S�Ǻ�ɫ��SR�Ǻ�ɫ�ģ�SLΪ������ɫ��������ԣ�
    1. ��P��ɫ��ֵ��S��
    2. ��P��Ϊ��ɫ��
    3. ��SR��Ϊ��ɫ��
    4. ��P����������
    5. ����NΪ�����ڵ㡱��
![GitHub](https://github.com/blacky8/Pictures/blob/master/RBTree_delete_case4.png)
	
###�����Ӧ��-TreeMap###
TreeMap��TreeSet��Java Collection Framework ��������Ҫ��Ա��
TreeMap��Map�ӿڵĳ���ʵ����,TreeSet��Set�ӿڵĳ���ʵ���ࡣ
TreeSet�ײ���ͨ��TreeMap��ʵ�ֵģ���˶��ߵ�ʵ�ַ�ʽ��ȫһ��, TreeMap ��ʵ�־��Ǻ�����㷨��

####TreeMap��TreeSet֮��Ĺ�ϵ####
Ϊ����ȷ����֮��Ĺ�ϵ����������TreeSet��Ĳ���Դ���룺
````java
public class TreeSet<E> extends AbstractSet<E> implements NavigableSet<E>, Cloneable, java.io.Serializable 
{ 
  // ʹ�� NavigableMap �� key ������ Set ���ϵ�Ԫ��
  private transient NavigableMap<E,Object> m; 
  // ʹ��һ�� PRESENT ��Ϊ Map ���ϵ����� value��
  private static final Object PRESENT = new Object(); 
  // ������Ȩ�޵Ĺ���������ָ���� NavigableMap ���󴴽� Set ����
  TreeSet(NavigableMap<E,Object> m) 
  { 
      this.m = m; 
  } 
  public TreeSet()                                      // ��
  { 
      // ����Ȼ����ʽ����һ���µ� TreeMap��
      // ���ݸ� TreeSet ����һ�� TreeSet��
      // ʹ�ø� TreeMap �� key ������ Set ���ϵ�Ԫ��
      this(new TreeMap<E,Object>()); 
  } 
  public TreeSet(Comparator<? super E> comparator)     // ��
  { 
      // �Զ�������ʽ����һ���µ� TreeMap��
      // ���ݸ� TreeSet ����һ�� TreeSet��
      // ʹ�ø� TreeMap �� key ������ Set ���ϵ�Ԫ��
      this(new TreeMap<E,Object>(comparator)); 
  } 
  public TreeSet(Collection<? extends E> c) 
  { 
      // ���âٺŹ���������һ�� TreeSet���ײ��� TreeMap ���漯��Ԫ��
      this(); 
      // �� TreeSet ����� Collection ���� c �������Ԫ��
      addAll(c); 
  } 
  public TreeSet(SortedSet<E> s) 
  { 
      // ���âںŹ���������һ�� TreeSet���ײ��� TreeMap ���漯��Ԫ��
      this(s.comparator()); 
      // �� TreeSet ����� SortedSet ���� s �������Ԫ��
      addAll(s); 
  } 
  //TreeSet ������������ֻ��ֱ�ӵ��� TreeMap �ķ������ṩʵ��
  ... 
  public boolean addAll(Collection<? extends E> c) 
  { 
      if (m.size() == 0 && c.size() > 0 && 
          c instanceof SortedSet && 
          m instanceof TreeMap) 
      { 
          // �� c ����ǿ��ת��Ϊ SortedSet ����
          SortedSet<? extends E> set = (SortedSet<? extends E>) c; 
          // �� m ����ǿ��ת��Ϊ TreeMap ����
          TreeMap<E,Object> map = (TreeMap<E, Object>) m; 
          Comparator<? super E> cc = (Comparator<? super E>) set.comparator(); 
          Comparator<? super E> mc = map.comparator(); 
          // ��� cc �� mc ���� Comparator ���
          if (cc == mc || (cc != null && cc.equals(mc))) 
          { 
              // �� Collection ������Ԫ����ӳ� TreeMap ���ϵ� key 
              map.addAllForTreeSet(set, PRESENT); 
              return true; 
          } 
      } 
      // ֱ�ӵ��ø���� addAll() ������ʵ��
      return super.addAll(c); 
  } 
  ... 
}
````
�����������Կ�����TreeSet�Ģٺš��ںŹ������Ķ����½�һ��TreeMap��Ϊʵ�ʴ洢SetԪ�ص�������������2����������ֱ������ڢٺź͢ںŹ�����
�ɴ˿ɼ���TreeSet�ײ�ʵ��ʹ�õĴ洢��������TreeMap����HashSet��ȫ���Ƶ��ǣ�TreeSet����󲿷ַ�������ֱ�ӵ���TreeMap�ķ�����ʵ�ֵġ�

��TreeMap���ԣ������á��������������Map��ÿ��Entry ���� ÿ��Entry�������ɡ����������һ���ڵ�Դ�������ͨ��Դ����˵��TreeMap���ڽڵ����ӣ�ɾ��������

####TreeMap ��ӽڵ�####
put(K key, V value) ����ʵ���˽� Entry ��������������У������Ǹ÷�����Դ���룺
````java
public V put(K key, V value) 
{ 
  // ���� t ��������� root �ڵ�
  Entry<K,V> t = root; 
  // ��� t==null��������һ������������ TreeMap ��û���κ� Entry 
  if (t == null) 
  { 
      // ���µ� key-value ����һ�� Entry�������� Entry ��Ϊ root 
      root = new Entry<K,V>(key, value, null); 
      // ���ø� Map ���ϵ� size Ϊ 1���������һ�� Entry 
      size = 1; 
      // ��¼�޸Ĵ���Ϊ 1 
      modCount++; 
      return null; 
  } 
  int cmp; 
  Entry<K,V> parent; 
  Comparator<? super K> cpr = comparator; 
  // ����Ƚ��� cpr ��Ϊ null�����������ö�������
  if (cpr != null) 
  { 
      do { 
          // ʹ�� parent �ϴ�ѭ����� t �����õ� Entry 
          parent = t; 
          // ���²��� key �� t �� key ���бȽ�
          cmp = cpr.compare(key, t.key); 
          // ����²���� key С�� t �� key��t ���� t ����߽ڵ�
          if (cmp < 0) 
              t = t.left; 
          // ����²���� key ���� t �� key��t ���� t ���ұ߽ڵ�
          else if (cmp > 0) 
              t = t.right; 
          // ������� key ��ȣ��µ� value ����ԭ�е� value��
          // ������ԭ�е� value 
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
          // ʹ�� parent �ϴ�ѭ����� t �����õ� Entry 
          parent = t; 
          // ���²��� key �� t �� key ���бȽ�
          cmp = k.compareTo(t.key); 
          // ����²���� key С�� t �� key��t ���� t ����߽ڵ�
          if (cmp < 0) 
              t = t.left; 
          // ����²���� key ���� t �� key��t ���� t ���ұ߽ڵ�
          else if (cmp > 0) 
              t = t.right; 
          // ������� key ��ȣ��µ� value ����ԭ�е� value��
          // ������ԭ�е� value 
          else 
              return t.setValue(value); 
      } while (t != null); 
  } 
  // ���²���Ľڵ���Ϊ parent �ڵ���ӽڵ�
  Entry<K,V> e = new Entry<K,V>(key, value, parent); 
  // ����²��� key С�� parent �� key���� e ��Ϊ parent �����ӽڵ�
  if (cmp < 0) 
      parent.left = e; 
  // ����²��� key С�� parent �� key���� e ��Ϊ parent �����ӽڵ�
  else 
      parent.right = e; 
  // �޸������
  fixAfterInsertion(e);                                
  size++; 
  modCount++; 
  return null; 
}
````
��ӽڵ����޸������� fixAfterInsertion(Entry<K,V> x) �����ṩ���÷�����Դ�������£�
````java
private void fixAfterInsertion(Entry<K,V> x) 
{ 
  x.color = RED; 
  // ֱ�� x �ڵ�ĸ��ڵ㲻�Ǹ����� x �ĸ��ڵ㲻�Ǻ�ɫ
  while (x != null && x != root 
      && x.parent.color == RED) 
  { 
      // ��� x �ĸ��ڵ����丸�ڵ�����ӽڵ�
      if (parentOf(x) == leftOf(parentOf(parentOf(x)))) 
      { 
          // ��ȡ x �ĸ��ڵ���ֵܽڵ�
          Entry<K,V> y = rightOf(parentOf(parentOf(x))); 
          // ��� x �ĸ��ڵ���ֵܽڵ��Ǻ�ɫ
          if (colorOf(y) == RED) 
          { 
              // �� x �ĸ��ڵ���Ϊ��ɫ
              setColor(parentOf(x), BLACK); 
              // �� x �ĸ��ڵ���ֵܽڵ���Ϊ��ɫ
              setColor(y, BLACK); 
              // �� x �ĸ��ڵ�ĸ��ڵ���Ϊ��ɫ
              setColor(parentOf(parentOf(x)), RED); 
              x = parentOf(parentOf(x)); 
          } 
          // ��� x �ĸ��ڵ���ֵܽڵ��Ǻ�ɫ
          else 
          { 
              // ��� x ���丸�ڵ�����ӽڵ�
              if (x == rightOf(parentOf(x))) 
              { 
                  // �� x �ĸ��ڵ���Ϊ x 
                  x = parentOf(x); 
                  rotateLeft(x); 
              } 
              // �� x �ĸ��ڵ���Ϊ��ɫ
              setColor(parentOf(x), BLACK); 
              // �� x �ĸ��ڵ�ĸ��ڵ���Ϊ��ɫ
              setColor(parentOf(parentOf(x)), RED); 
              rotateRight(parentOf(parentOf(x))); 
          } 
      } 
      // ��� x �ĸ��ڵ����丸�ڵ�����ӽڵ�
      else 
      { 
          // ��ȡ x �ĸ��ڵ���ֵܽڵ�
          Entry<K,V> y = leftOf(parentOf(parentOf(x))); 
          // ��� x �ĸ��ڵ���ֵܽڵ��Ǻ�ɫ
          if (colorOf(y) == RED) 
          { 
              // �� x �ĸ��ڵ���Ϊ��ɫ��
              setColor(parentOf(x), BLACK); 
              // �� x �ĸ��ڵ���ֵܽڵ���Ϊ��ɫ
              setColor(y, BLACK); 
              // �� x �ĸ��ڵ�ĸ��ڵ���Ϊ��ɫ
              setColor(parentOf(parentOf(x)), RED); 
              // �� x ��Ϊ x �ĸ��ڵ�Ľڵ�
              x = parentOf(parentOf(x)); 
          } 
          // ��� x �ĸ��ڵ���ֵܽڵ��Ǻ�ɫ
          else 
          { 
              // ��� x ���丸�ڵ�����ӽڵ�
              if (x == leftOf(parentOf(x))) 
              { 
                  // �� x �ĸ��ڵ���Ϊ x 
                  x = parentOf(x); 
                  rotateRight(x); 
              } 
              // �� x �ĸ��ڵ���Ϊ��ɫ
              setColor(parentOf(x), BLACK); 
              // �� x �ĸ��ڵ�ĸ��ڵ���Ϊ��ɫ
              setColor(parentOf(parentOf(x)), RED); 
              rotateLeft(parentOf(parentOf(x))); 
          } 
      } 
  } 
  // �����ڵ���Ϊ��ɫ
  root.color = BLACK; 
}
````  
####TreeMap ɾ���ڵ�####
TreeMapɾ���ڵ�ʱ�����ñ�ɾ���ڵ������������С�ڵ��뱻ɾ�ڵ㽻���ķ�ʽ����ά����
deleteEntry(Entry<K,V> p) ����ʵ���˽� Entry �������������ɾ���������Ǹ÷�����Դ���룺
````java
private void deleteEntry(Entry<K,V> p) 
 { 
    modCount++; 
    size--; 
    // �����ɾ���ڵ��������������������Ϊ��
    if (p.left != null && p.right != null) 
    { 
        // �� p �ڵ�������̽ڵ���� p �ڵ�
        Entry<K,V> s = successor (p); 
        p.key = s.key; 
        p.value = s.value; 
        p = s; 
    } 
    // ��� p �ڵ����ڵ���ڣ�replacement ������ڵ㣻��������ҽڵ㡣
    Entry<K,V> replacement = (p.left != null ? p.left : p.right); 
    if (replacement != null) 
    { 
        replacement.parent = p.parent; 
        // ��� p û�и��ڵ㣬�� replacemment ��ɸ��ڵ�
        if (p.parent == null) 
            root = replacement; 
        // ��� p �ڵ����丸�ڵ�����ӽڵ�
        else if (p == p.parent.left) 
            p.parent.left  = replacement; 
        // ��� p �ڵ����丸�ڵ�����ӽڵ�
        else 
            p.parent.right = replacement; 
        p.left = p.right = p.parent = null; 
        // �޸������
        if (p.color == BLACK) 
            fixAfterDeletion(replacement);       
    } 
    // ��� p �ڵ�û�и��ڵ�
    else if (p.parent == null) 
    { 
        root = null; 
    } 
    else 
    { 
        if (p.color == BLACK) 
            // �޸������
            fixAfterDeletion(p);                 
        if (p.parent != null) 
        { 
            // ��� p ���丸�ڵ�����ӽڵ�
            if (p == p.parent.left) 
                p.parent.left = null; 
            // ��� p ���丸�ڵ�����ӽڵ�
            else if (p == p.parent.right) 
                p.parent.right = null; 
            p.parent = null; 
        } 
    } 
 }
````
ɾ��֮����޸������� fixAfterDeletion(Entry<K,V> x) �����ṩ���÷���Դ�������£�
````java
private void fixAfterDeletion(Entry<K,V> x) 
{ 
  // ֱ�� x ���Ǹ��ڵ㣬�� x ����ɫ�Ǻ�ɫ
  while (x != root && colorOf(x) == BLACK) 
  { 
      // ��� x ���丸�ڵ�����ӽڵ�
      if (x == leftOf(parentOf(x))) 
      { 
          // ��ȡ x �ڵ���ֵܽڵ�
          Entry<K,V> sib = rightOf(parentOf(x)); 
          // ��� sib �ڵ��Ǻ�ɫ
          if (colorOf(sib) == RED) 
          { 
              // �� sib �ڵ���Ϊ��ɫ
              setColor(sib, BLACK); 
              // �� x �ĸ��ڵ���Ϊ��ɫ
              setColor(parentOf(x), RED); 
              rotateLeft(parentOf(x)); 
              // �ٴν� sib ��Ϊ x �ĸ��ڵ�����ӽڵ�
              sib = rightOf(parentOf(x)); 
          } 
          // ��� sib �������ӽڵ㶼�Ǻ�ɫ
          if (colorOf(leftOf(sib)) == BLACK 
              && colorOf(rightOf(sib)) == BLACK) 
          { 
              // �� sib ��Ϊ��ɫ
              setColor(sib, RED); 
              // �� x ���� x �ĸ��ڵ�
              x = parentOf(x); 
          } 
          else 
          { 
              // ��� sib ��ֻ�����ӽڵ��Ǻ�ɫ
              if (colorOf(rightOf(sib)) == BLACK) 
              { 
                  // �� sib �����ӽڵ�Ҳ��Ϊ��ɫ
                  setColor(leftOf(sib), BLACK); 
                  // �� sib ��Ϊ��ɫ
                  setColor(sib, RED); 
                  rotateRight(sib); 
                  sib = rightOf(parentOf(x)); 
              } 
              // ���� sib ����ɫ�� x �ĸ��ڵ����ɫ��ͬ
              setColor(sib, colorOf(parentOf(x))); 
              // �� x �ĸ��ڵ���Ϊ��ɫ
              setColor(parentOf(x), BLACK); 
              // �� sib �����ӽڵ���Ϊ��ɫ
              setColor(rightOf(sib), BLACK); 
              rotateLeft(parentOf(x)); 
              x = root; 
          } 
      } 
      // ��� x ���丸�ڵ�����ӽڵ�
      else 
      { 
          // ��ȡ x �ڵ���ֵܽڵ�
          Entry<K,V> sib = leftOf(parentOf(x)); 
          // ��� sib ����ɫ�Ǻ�ɫ
          if (colorOf(sib) == RED) 
          { 
              // �� sib ����ɫ��Ϊ��ɫ
              setColor(sib, BLACK); 
              // �� sib �ĸ��ڵ���Ϊ��ɫ
              setColor(parentOf(x), RED); 
              rotateRight(parentOf(x)); 
              sib = leftOf(parentOf(x)); 
          } 
          // ��� sib �������ӽڵ㶼�Ǻ�ɫ
          if (colorOf(rightOf(sib)) == BLACK 
              && colorOf(leftOf(sib)) == BLACK) 
          { 
              // �� sib ��Ϊ��ɫ
              setColor(sib, RED); 
              // �� x ���� x �ĸ��ڵ�
              x = parentOf(x); 
          } 
          else 
          { 
              // ��� sib ֻ�����ӽڵ��Ǻ�ɫ
              if (colorOf(leftOf(sib)) == BLACK) 
              { 
                  // �� sib �����ӽڵ�Ҳ��Ϊ��ɫ
                  setColor(rightOf(sib), BLACK); 
                  // �� sib ��Ϊ��ɫ
                  setColor(sib, RED); 
                  rotateLeft(sib); 
                  sib = leftOf(parentOf(x)); 
              } 
              // �� sib ����ɫ��Ϊ�� x �ĸ��ڵ���ɫ��ͬ
              setColor(sib, colorOf(parentOf(x))); 
              // �� x �ĸ��ڵ���Ϊ��ɫ
              setColor(parentOf(x), BLACK); 
              // �� sib �����ӽڵ���Ϊ��ɫ
              setColor(leftOf(sib), BLACK); 
              rotateRight(parentOf(x)); 
              x = root; 
          } 
      } 
  } 
  setColor(x, BLACK); 
}
````
####�����ڵ�####
��TreeMap����key��ȡ��valueʱ��TreeMap��Ӧ�ķ������£�
````java
public V get(Object key) 
{ 
  // ����ָ�� key ȡ����Ӧ�� Entry 
  Entry>K,V< p = getEntry(key); 
  // ���ظ� Entry �������� value 
  return (p==null ? null : p.value); 
}
````
���������Ĵ����ִ�����Կ�����get(Object key) ����ʵ�������� getEntry() ����ʵ�ֵģ���� getEntry() �����Ĵ������£�
````java
 final Entry<K,V> getEntry(Object key) 
 { 
    // ��� comparator ��Ϊ null������������ö�������
    if (comparator != null) 
        // ���� getEntryUsingComparator ������ȡ����Ӧ�� key 
        return getEntryUsingComparator(key); 
    // ��� key �βε�ֵΪ null���׳� NullPointerException �쳣
    if (key == null) 
        throw new NullPointerException(); 
    // �� key ǿ������ת��Ϊ Comparable ʵ��
    Comparable<? super K> k = (Comparable<? super K>) key; 
    // �����ĸ��ڵ㿪ʼ
    Entry<K,V> p = root; 
    while (p != null) 
    { 
        // �� key �뵱ǰ�ڵ�� key ���бȽ�
        int cmp = k.compareTo(p.key); 
        // ��� key С�ڵ�ǰ�ڵ�� key����������������
        if (cmp < 0) 
            p = p.left; 
        // ��� key ���ڵ�ǰ�ڵ�� key����������������
        else if (cmp > 0) 
            p = p.right; 
        // �����ڡ���С�ڣ������ҵ���Ŀ�� Entry 
        else 
            return p; 
    } 
    return null; 
 }
 ````
����� getEntry(Object obj) ����Ҳ�ǳ���������������������������Ŀ�� Entry��
������Ȼ�Ӷ������ĸ��ڵ㿪ʼ������������ڵ���ڵ�ǰ�ڵ㣬������������������������������ڵ�С�ڵ�ǰ�ڵ㣬�������������������������ȣ��Ǿ����ҵ���ָ���ڵ㡣
�� TreeMap ��� comparator != null �������� TreeMap �����˶��������ڲ��ö�������ķ�ʽ�£�TreeMap ���� getEntryUsingComparator(key) ���������� key ��ȡ Entry�������Ǹ÷����Ĵ��룺
````java
final Entry<K,V> getEntryUsingComparator(Object key) 
{ 
  K k = (K) key; 
  // ��ȡ�� TreeMap �� comparator 
  Comparator<? super K> cpr = comparator; 
  if (cpr != null) 
  { 
      // �Ӹ��ڵ㿪ʼ
      Entry<K,V> p = root; 
      while (p != null) 
      { 
          // �� key �뵱ǰ�ڵ�� key ���бȽ�
          int cmp = cpr.compare(k, p.key); 
          // ��� key С�ڵ�ǰ�ڵ�� key����������������
          if (cmp < 0) 
              p = p.left; 
          // ��� key ���ڵ�ǰ�ڵ�� key����������������
          else if (cmp > 0) 
              p = p.right; 
          // �����ڡ���С�ڣ������ҵ���Ŀ�� Entry 
          else 
              return p; 
      } 
  } 
  return null; 
}
````
��ʵ getEntry��getEntryUsingComparator ����������ʵ��˼·��ȫ���ƣ�ֻ��ǰ�߶���Ȼ����� TreeMap ��ȡ��Ч�����߶Զ�������� TreeMap ��Ч��
ͨ������Դ����ķ������ѿ�����TreeMap ����������ʵ����ʵ�ܼ򵥡����ڲ��ṹ������TreeMap �����Ͼ���һ�á������������ TreeMap ��ÿ�� Entry ���Ǹú������һ���ڵ㡣

�ο����ף�
<br>http://www.cnblogs.com/skywang12345/p/3245399.html
<br>http://www.ibm.com/developerworks/cn/java/j-lo-tree/
<br>http://blog.csdn.net/v_JULY_v/article/details/6109153