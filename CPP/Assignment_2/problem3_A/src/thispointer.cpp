#include <iostream>
using namespace std;

class Entity
{
private:
    string name;
    int health;
    int level;
    string type;

public:
    // Setters
    Entity& setName(const string& name);
    Entity& setHealth(int health);
    Entity& setLevel(int level);
    Entity& setType(const string& type);

    // Getters
    string getName() const;
    int getHealth() const;
    int getLevel() const;
    string getType() const;

    void displayInfo() const;
};


Entity& Entity::setName(const string& name)
{
    this->name = name;
    return *this;
}

Entity& Entity::setHealth(int health)
{
    this->health = health;
    return *this;
}
Entity& Entity::setLevel(int level)
{
    this->level = level;
    return *this;
}

Entity& Entity::setType(const string& type)
{
    this->type = type;
    return *this;
}

string Entity::getName() const
{
    return name;
}

int Entity::getHealth() const
{
    return health;
}

int Entity::getLevel() const
{
    return level;
}

string Entity::getType() const
{
    return type;
}

void Entity::displayInfo() const
{
    cout << "\nEntity Information:" << endl;
    cout << "Name   : " << name << endl;
    cout << "Health : " << health << endl;
    cout << "Level  : " << level << endl;
    cout << "Type   : " << type << endl;
}


int main()
{
    Entity player, enemy, item;

    player.setName("Aragorn").setHealth(100).setLevel(10).setType("Player");

    enemy.setName("Orc").setHealth(60).setLevel(5).setType("Enemy");

    item.setName("HealthPotion").setHealth(0).setLevel(1).setType("Item");

    player.displayInfo();
    enemy.displayInfo();
    item.displayInfo();

    return 0;
}
