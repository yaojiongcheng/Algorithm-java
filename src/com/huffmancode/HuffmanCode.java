package com.huffmancode;

import java.io.*;
import java.util.*;

public class HuffmanCode {

    public static void main(String[] args) {

        // 测试压缩文件
        /*String srcFile = "D:\\test.bmp";
        String dstFile = "D:\\test.zip";

        zipFile(srcFile,dstFile);
        System.out.println("压缩文件ok~");*/

        // 测试解压文件
        String zipFile = "D:\\test.zip";
        String dstFile = "D:\\test2.bmp";
        unzipFile(zipFile,dstFile);
        System.out.println("解压成功~");

        /*
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        System.out.println(contentBytes.length); // 40个

        byte[] huffmanCodesBytes = huffmanZip(contentBytes);
        System.out.println("压缩后的结果是：" + Arrays.toString(huffmanCodesBytes) + "\n长度 = " + huffmanCodesBytes.length); // 17个

        // 测试一把byteToBitString()
        byte[] sourceBytes = decode(huffmanCodes,huffmanCodesBytes);
        System.out.println("原来的字符串 = " + new String(sourceBytes)); // "i like like like java do you like a java"
         */

        // 如何将数据进行解压（解码）
        // 分步过程
        /*
        List<Node> nodes = getNodes(contentBytes);
        System.out.println("nodes = " + nodes);

        // 测试创建的哈夫曼树
        System.out.println("哈夫曼树");
        Node huffmanTreeRoot = createHuffmanTree(nodes);
        System.out.println("前序遍历");
        preOrder(huffmanTreeRoot);

        // 测试是否生成了对应的哈夫曼编码
        Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);

        System.out.println("生成的哈夫曼编码表 = " + huffmanCodes);

        // 测试
        byte[] huffmanCodeBytes = zip(contentBytes,huffmanCodes);
        System.out.println("huffmanCodeBytes = " + Arrays.toString(huffmanCodeBytes)); // 17个

        // 发送huffmanCodeBytes 数组*/

    }

    // 编写一个方法，完成对压缩文件的解压
    /**
     *
     * @param zipFile 准备解压的文件
     * @param dstFile 将文件解压到哪个路径
     */
    public static void unzipFile(String zipFile,String dstFile) {
        // 定义文件的输入流
        InputStream is = null;
        // 定义一个对象输入流
        ObjectInputStream ois = null;
        // 定义文件的输出流
        OutputStream os = null;
        try {
            // 创建文件输入流
            is = new FileInputStream(zipFile);
            // 创建一个和is关联的对象输入流
            ois = new ObjectInputStream(is);
            // 读取byte数组 huffmanBytes
            byte[] huffmanBytes = (byte[]) ois.readObject();
            // 读取哈夫曼编码表
            Map<Byte,String> huffmanCodes = (Map<Byte, String>) ois.readObject();

            // 解码
            byte[] bytes = decode(huffmanCodes,huffmanBytes);
            // 将bytes数组写入到目标文件
            os = new FileOutputStream(dstFile);
            // 写数据到 dstFile 文件
            os.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
                ois.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 编写方法，将一个文件进行压缩
    /**
     *
     * @param srcFile 传入的希望压缩的文件的全路径
     * @param dstFile 压缩后将压缩文件放到哪个目录下
     */
    public static void zipFile(String srcFile,String dstFile) {

        // 创建输出流
        OutputStream os = null;
        ObjectOutputStream oos = null;
        // 创建文件的输入流
        FileInputStream is = null;
        try {
            is = new FileInputStream(srcFile);
            // 创建一个和源文件大小一样的byte[]
            byte[] b = new byte[is.available()];
            // 读取文件
            is.read(b);
            // 直接对源文件压缩
            byte[] huffmanBytes = huffmanZip(b);
            // 创建文件的输出流，存放压缩文件
            os = new FileOutputStream(dstFile);
            // 创建一个和文件输出流关联的ObjectOutputStream
            oos = new ObjectOutputStream(os);
            // 把哈夫曼编码后的字节数组写入压缩文件
            oos.writeObject(huffmanBytes);

            // 这里我们以对象流的方式写入 哈夫曼编码，是为了以后我们恢复原文件时使用
            // 注意一定要把哈夫曼编码 写入压缩文件
            oos.writeObject(huffmanCodes);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                oos.close();
                os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    // 完成数据的解压
    // 思路
    // 1.将huffmanCodeBytes:[-88, -65, -56, -65, -56, -65, -55, 77, -57, 6, -24, -14, -117, -4, -60, -90, 28]
    // 重新先转成哈夫曼编码对应的二进制的字符串: 1010100010111111110010001011111111001000101111111100100101001101110001110000011011101000111100101000101111111100110001001010011011100
    // 2.将哈夫曼编码对应的二进制的字符串: 10101000... =》 对照哈夫曼编码 =》 i like like like java do you like a java

    // 编写一个方法，完成对压缩数据的解码

    /**
     *
     * @param huffmanCodes 哈夫曼编码表 map
     * @param huffmanBytes 哈夫曼编码得到的字节数组
     * @return 就是原来的字符串对应的数组
     */
    private static byte[] decode(Map<Byte,String> huffmanCodes,byte[] huffmanBytes) {

        // 1.先得到huffmanBytes对应的二进制的字符串，形式 10101000...
        StringBuilder stringBuilder = new StringBuilder();
        // 将byte数组转成二进制的字符串
        for (int i = 0; i < huffmanBytes.length; i++) {
            Byte b = huffmanBytes[i];
            // 判断是不是最后一个字节
            boolean flag = (i == huffmanBytes.length - 1);
            stringBuilder.append(byteToBitString(!flag, b));
        }

        // 把字符串按照指定的哈夫曼编码进行解码
        // 把哈夫曼编码表进行调换，因为方向查询 a -> 100    100 -> a
        Map<String, Byte> map = new HashMap<String, Byte>();
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }

        // 创建一个集合，存放byte
        List<Byte> list = new ArrayList<>();
        // i 可以理解成就是一个索引，扫描stringBuilder
        for (int i = 0; i < stringBuilder.length();) {
            int count = 1; // 小的计数器
            boolean flag = true;
            Byte b = null;

            while (flag) {
                // 递增的取出 key
                String key = stringBuilder.substring(i, i + count); // i不动，让count移动，直到匹配到一个字符
                b = map.get(key);
                if (b == null) {
                    // 说明没有匹配到
                    count++;
                } else {
                    // 匹配到
                    flag = false;
                }
            }
            list.add(b);
            i += count; // i 直接移动到 count
        }
        // 当for循环结束后，我们list中就存放了所有的字符 "i like like like java do you like a java"
        // 把list中的数据放入到byte[] 并返回
        byte[] b = new byte[list.size()];
        for (int i = 0; i < b.length; i++) {
            b[i] = list.get(i);
        }
        return b;
    }

    /**
     * 将一个byte转成一个二进制的字符串，如果看不懂，可以参考 二进制的原码，反码，补码
     * @param b 传入的byte
     * @param flag 标识是否需要补高位，如果true，表示需要补高位，如果是false表示不补，如果是最后一个字节，无需补高位
     * @return 是该b对应的二进制的字符串（注意是按补码返回的）
     */
    private static String byteToBitString(boolean flag,byte b) {
        // 使用一个变量保存 b
        int temp = b; // 将b转成int

        // 如果是正数我们还存在补高位
        if (flag) {
            temp |= 256; // 按位与 256 == 1 0000 0000 | 0000 0001 =》 1 0000 0001
        }

        String str = Integer.toBinaryString(temp); // 返回的是temp对应的二进制的补码

        if (flag) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }

    // 使用一个方法，将前面的方法封装起来，便于我们的调用

    /**
     *
     * @param bytes 原始的字符串对应的字节数组
     * @return 返回的是经过哈夫曼编码处理后的字节数组（压缩后的数组）
     */
    private static byte[] huffmanZip(byte[] bytes) {
        List<Node> nodes = getNodes(bytes);
        // 根据nodes创建哈夫曼树
        Node huffmanTreeRoot = createHuffmanTree(nodes);
        // 对应的哈夫曼编码（根据 哈夫曼树）
        Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
        // 根据生成的哈夫曼编码，压缩得到压缩后的哈夫曼编码字节数组
        byte[] huffmanCodeBytes = zip(bytes,huffmanCodes);
        return huffmanCodeBytes;
    }

    // 编写一个方法，将字符串对应的byte[] 数组，通过生成的哈夫曼编码表，返回一个哈夫曼编码压缩后的byte[]
    /**
     * @param bytes 这是原始的字符串对应的byte[]
     * @param huffmanCodes 生成的哈夫曼编码map
     * @return 返回哈夫曼编码处理后的byte[]
     * 举例 String content = "i like like like java do you like a java"; => byte[] contentBytes = content.getBytes();
     * 返回的是
     * 字符串“1010100010111111110010001011111111001000101111111100100101001101110001110000011011101000111100101000101111111100110001001010011011100”
     * => 对应的byte[] huffmanCodeBytes,即8位对应一个byte，放入到 huffmanCodeBytes
     * huffmanCodeBytes[0] = 10101000(补码) => byte [推导 10101000 => 10101000-1 => 10100111(反码) => 11011000(原码) => -88]
     * huffmanCodeBytes[1] = -88
     */
    private static byte[] zip(byte[] bytes,Map<Byte,String> huffmanCodes) {

        // 1.利用huffmanCodes将bytes转成哈夫曼编码对应的字符串
        StringBuilder stringBuilder = new StringBuilder();
        // 遍历bytes数组
        for (byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }

        // System.out.println("测试stringBuilder = " + stringBuilder.toString());

        // 将“10101000……”转成byte[]

        // 统计返回的 byte[] huffmanCodeBytes 长度
        // 一句话搞定 int len = (stringBuilder.length() + 7) / 8;
        int len;
        if (stringBuilder.length() % 8 == 0) {
            len = stringBuilder.length() / 8;
        } else {
            len = stringBuilder.length() / 8 + 1;
        }
        // 创建 存储压缩后的 byte数组
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0; //记录是第几个byte
        for (int i = 0; i < stringBuilder.length(); i+=8) {
            // 因为是每八位对应一个byte，所以步长 +8
            String strByte;
            if (i+8 > stringBuilder.length()) {
                // 不够八位
                strByte = stringBuilder.substring(i);
            } else {
                strByte = stringBuilder.substring(i, i + 8);
            }
            // 将strByte转成一个byte，放入到huffmanCodeBytes
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte,2);
            index++;
        }

        return huffmanCodeBytes;

    }

    // 生成哈夫曼树对应的哈夫曼编码
    // 思路：
    // 1.将哈夫曼编码表存放在Map<Byte,String> 形式
    //  32->01 97->100 100->11000 ……[形式]
    static Map<Byte,String> huffmanCodes = new HashMap<Byte,String>();
    // 2.在生成哈夫曼编码表时，需要去拼接路径，定义一个StringBuilder 存储某个叶子节点的路径
    static StringBuilder stringBuilder = new StringBuilder();

    // 为了调用方便，我们重载getCodes
    private static Map<Byte,String> getCodes(Node root) {
        if (root == null) {
            return null;
        }
        // 处理root的左子树
        getCodes(root.left,"0",stringBuilder);
        // 处理root的右子树
        getCodes(root.right,"1",stringBuilder);
        return huffmanCodes;
    }

    /**
     * 功能：将传入的node节点的所有叶子节点的哈夫曼编码得到，并放入到huffmanCodes集合中
     * @param node 传入的节点
     * @param code 路径：左子节点是0，右子节点是1
     * @param stringBuilder 用于拼接路径
     */
    private static void getCodes(Node node,String code,StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        // 将code 加入到 stringBuilder2
        stringBuilder2.append(code);
        if (node != null) {
            // 如果node == null 不处理
            // 判断当前node 是叶子节点还是非叶子节点
            if (node.data == null) {
                // 非叶子节点
                // 递归处理
                // 向左递归
                getCodes(node.left,"0",stringBuilder2);
                // 向右递归
                getCodes(node.right,"1",stringBuilder2);
            } else {
                // 说明他是一个叶子节点
                // 就表示找到某个叶子节点的最后
                huffmanCodes.put(node.data,stringBuilder2.toString());
            }
        }
    }

    // 前序遍历的方法
    private static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("哈夫曼树为空树，不能遍历");
        }
    }

    /**
     * @param bytes 接收字节数组
     * @return 返回的就是 List 形式 [Node[data=97,weight=5],Node[data=32,weight=9]...]
     */
    private static List<Node> getNodes(byte[] bytes) {

        // 1.创建一个ArrayList
        ArrayList<Node> nodes = new ArrayList<>();

        // 遍历 bytes ，统计每个byte出现的次数 -》 map[key,value]
        Map<Byte,Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) {
                // Map还没有这个字符数据 第一次接收到
                counts.put(b,1);
            } else {
                counts.put(b,count+1);
            }
        }

        // 把每一个键值对转成一个Node对象，并加入到nodes集合
        // 遍历Map
        for (Map.Entry<Byte,Integer> entry : counts.entrySet()) {
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }

        return nodes;
    }

    // 通过List创建对应的哈夫曼树
    private static Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            // 排序,从小到大排序
            Collections.sort(nodes);
            // 取出第一颗最小的二叉树
            Node leftNode = nodes.get(0);
            // 取出第二颗最小的二叉树
            Node rightNode = nodes.get(1);
            // 创建一颗新的二叉树,他的根节点没有data，只有权值
            Node parent = new Node(null,leftNode.weight+rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;

            // 将已经处理的两颗二叉树从nodes中删除
            nodes.remove(leftNode);
            nodes.remove(rightNode);

            // 将新的二叉树加入到nodes
            nodes.add(parent);

        }

        // 最后的节点，就是哈夫曼树的根节点
        return nodes.get(0);
    }

}

// 创建Node，待数据和权值
class Node implements Comparable<Node> {
    Byte data; // 存放数据（字符）本身，比如‘a’ => 97     ' ' => 32
    int weight; // 权值，表示字符出现的次数
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        // 从小到大排序
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    // 前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }
}
