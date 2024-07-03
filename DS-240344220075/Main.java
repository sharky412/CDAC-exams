package exam;

import java.util.Scanner;

//Product class
class Product {
 int productId;
 String name;
 String type;
 double price;
 
 public Product(int productId, String name, String type, double price) {
     this.productId = productId;
     this.name = name;
     this.type = type;
     this.price = price;
 }
 
 @Override
 public String toString() {
     return String.format("Product ID: %d, Name: %s, Type: %s, Price: %.2f", productId, name, type, price);
 }
}

//Node class
class Node {
 Product product;
 Node next;
 Node prev;
 
 public Node(Product product) {
     this.product = product;
     this.next = null;
     this.prev = null;
 }
}

//CircularLinkedList class
class CircularLinkedList {
 private Node head;
 private Node tail;
 
 public CircularLinkedList() {
     head = null;
     tail = null;
 }
 
 public boolean isEmpty() {
     return head == null;
 }
 
 public void addProduct(Product product) {
     Node newNode = new Node(product);
     if (isEmpty()) {
         head = newNode;
         tail = newNode;
         newNode.next = newNode;
         newNode.prev = newNode;
     } else {
         newNode.prev = tail;
         newNode.next = head;
         tail.next = newNode;
         head.prev = newNode;
         tail = newNode;
     }
 }
 
 public void displayAllProducts() {
     if (isEmpty()) {
         System.out.println("List is empty");
         return;
     }
     Node current = head;
     do {
         System.out.println(current.product);
         current = current.next;
     } while (current != head);
 }
 
 public Product findProductById(int productId) throws Exception {
     if (isEmpty()) {
         throw new Exception("List is empty");
     }
     Node current = head;
     do {
         if (current.product.productId == productId) {
             return current.product;
         }
         current = current.next;
     } while (current != head);
     throw new Exception("Product with ID " + productId + " not found");
 }
 
 public void deleteFirstNode() throws Exception {
     if (isEmpty()) {
         throw new Exception("List is empty");
     }
     if (head == tail) { // Only one node
         head = null;
         tail = null;
     } else {
         head = head.next;
         head.prev = tail;
         tail.next = head;
     }
 }
 
 public void editProductByName(String oldName, String newName) throws Exception {
     if (isEmpty()) {
         throw new Exception("List is empty");
     }
     Node current = head;
     boolean found = false;
     do {
         if (current.product.name.equals(oldName)) {
             current.product.name = newName;
             found = true;
             break;
         }
         current = current.next;
     } while (current != head);
     if (!found) {
         throw new Exception("Product with name '" + oldName + "' not found");
     }
 }
}

//Example usage
public class Main {
 public static void main(String[] args) throws Exception {
     // Create a circular linked list
     CircularLinkedList circularList = new CircularLinkedList();
     Scanner sc = new Scanner(System.in);
		int choice=0;
		do {
		
		System.out.println("Menu");
		System.out.println("1. Add product at the last node");
		System.out.println("2. display all products");
		System.out.println("3. display specific product on basic of product id");
		System.out.println("4. delete first product");
		System.out.println("5. edit products name");
		System.out.println("6. exit");
		System.out.println("Enter your choice");
		choice=sc.nextInt();
		switch(choice) {
		case 1:
			System.out.println("Enter id of product");
			int id=sc.nextInt();
			System.out.println("Enter name of product");
			String name=sc.next();
			System.out.println("Enter type of product");
			String type=sc.next();
			System.out.println("Enter price of product");
			int price=sc.nextInt();
			Product p=new Product(id,name,type,price);
			circularList.addProduct(p);
			break;
		
		case 2:
			System.out.println("displaying all products");
			System.out.println("------------");
			circularList.displayAllProducts();
			break;
		
		case 3:
			System.out.println("Enter product id to display product data");
			int id1=sc.nextInt();
			System.out.println(circularList.findProductById(id1));
			System.out.println("------------");
			break;
		
		case 4:
			System.out.println("Deleting first product");
			System.out.println("------------");
			circularList.deleteFirstNode();
			break;
			
		case 5:
			System.out.println("Enter name of product you want to update name for");
			String name1=sc.next();
			System.out.println("Enter updated name of product");
			String updateName=sc.next();
			System.out.println("------------");
			circularList.editProductByName(name1,updateName);
			break;
		
		
		default:
			System.out.println("Enter valid choice");
			break;
		
		}}while(choice!=6);		
	}
}
