#include <iostream>
#include <vector>
using namespace std;

class Product
{
private:
    int id, price;
    string productName;
    static int laptopCount;
    static int cameraCount;
    static int watchCount;
    static int totalBill;

public:
    void setId(int id) { this->id = id; }
    void setPrice(int price) { this->price = price; }
    void setProductName(string productName) { this->productName = productName; }
    int getId() const { return id; }
    int getPrice() const { return price; }
    string getProductName() const { return productName; }

    void addNewProduct()
    {
        cout << "Enter name of the product you want to add: ";
        cin >> productName;
        cout << "Enter ID for the new product: ";
        cin >> id;
        cout << "Enter Price for the new product: $";
        cin >> price;
    }

    void addProduct(int choice, vector<Product> &products)
    {
        Product newProduct;
        switch (choice)
        {
        case 1:
            laptopCount++;
            newProduct.setProductName("Laptop");
            newProduct.setPrice(4000);
            cout << "Adding laptop. ";
            break;
        case 2:
            cameraCount++;
            newProduct.setProductName("Camera");
            newProduct.setPrice(800);
            cout << "Adding camera. ";
            break;
        case 3:
            watchCount++;
            newProduct.setProductName("Watch");
            newProduct.setPrice(500);
            cout << "Adding watch. ";
            break;
        default:
            cout << "Invalid choice.";
            return;
        }
        totalBill += newProduct.getPrice();
        newProduct.setId(products.size() + 1);
        products.push_back(newProduct);
        cout << "Total bill is: $" << totalBill << endl;
    }

    static void showProduct(const vector<Product> &products)
    {
        cout << "Purchased products: " << endl;
        for (const auto &product : products)
        {
            cout << "Product ID: " << product.getId() << ", Name: " << product.getProductName() << ", Price: $" << product.getPrice() << endl;
        }
    }

    static int getTotalBill()
    {
        return totalBill;
    }
};

int Product::laptopCount = 0;
int Product::cameraCount = 0;
int Product::watchCount = 0;
int Product::totalBill = 0;

class Person
{
private:
    string name;

public:
    void acceptPerson()
    {
        cout << "Enter the name of the customer: ";
        cin >> name;
    }

    void displayPerson()
    {
        cout << "Customer details: " << name << endl;
    }
};

class Customer : public Person, public Product
{
private:
    int mobileNo;

public:
    void acceptDetails()
    {
        acceptPerson();
        cout << "Enter customer mobile no: ";
        cin >> mobileNo;
    }

    void displayDetails()
    {
        displayPerson();
        cout << "Mobile No: " << mobileNo << endl;
    }
};

int main()
{
    Customer array[1];
    vector<Product> products;
    int choice;

    do
    {
        cout << "Menu for Spectacular Mart:" << endl;
        cout << "0. Exit" << endl;
        cout << "1. Display all products" << endl;
        cout << "2. New customer" << endl;
        cout << "3. New product" << endl;
        cout << "4. Purchase Product" << endl;
        cout << "5. Checkout" << endl;
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice)
        {
        case 1:
            cout << "Products are as follows:" << endl;
            Product::showProduct(products);
            break;

        case 2:
            array[0].acceptDetails();
            array[0].displayDetails();
            break;

        case 3:
            array[0].addNewProduct();
            break;

        case 4:
            cout << "Enter the product type you want to purchase (1 for Laptop, 2 for Camera, 3 for Watch): ";
            cin >> choice;
            array[0].addProduct(choice, products);
            break;

        case 5:
            cout << "Purchased products: " << endl;
            Product::showProduct(products);
            cout << "Total bill is: $" << Product::getTotalBill() << endl;
            break;

        default:
            if (choice != 0)
            {
                cout << "Enter a valid choice.";
            }
        }
    } while (choice != 0);

    return 0;
}
