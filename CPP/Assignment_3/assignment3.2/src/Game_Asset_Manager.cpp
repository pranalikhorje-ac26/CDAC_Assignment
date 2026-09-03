#include<iostream>
#include<memory>
using namespace std;
//============Part-A : unique_ptr : Exclusive Asset Ownership=====================
class Texture {
	string name;
	int width;
	int height;

public:
	Texture(string n,int w,int h) : name(n), width(w),height(h) {
		cout << "Texture Loaded" << endl;
	}

	~Texture(){
		cout << "Texture Released" << endl;
	}
	void display()const{
		cout << "Dimensions: "<< width << "x" << height << endl;
	}
};

//=============================Part-B :  shared_ptr : Shared Shader Ownership================

class Shader {
	string name;
	string type;

public :
	Shader(string n , string t) : name(n), type(t){
		cout << "Shader Compiled" << endl;
	}

	~Shader(){
		cout << "Shader Destroy" <<endl;
	}
};


int getReferenceCount(const shared_ptr<Shader>& shader) {
    return shader.use_count();
}
//===========Part C — weak_ptr : Non-Owning Observer===================
class AudioClip {
    string name;
    double duration;

public:
    AudioClip(string n, double d): name(n), duration(d) {
        cout << "AudioClip Loaded" << endl;
    }

    ~AudioClip() {
        cout << "AudioClip Released" << endl;
    }

    string getName() const {
        return name;
    }
};



/// main function

int main(){
//=================Part A — unique_ptr : Exclusive Asset Ownership==================
	auto tex1 = make_unique<Texture>("player_sprite", 512, 512);
	tex1->display();
//	unique_ptr<Texture> tex2 = tex1;  Error: unique_ptr cannot be copied because it allows only one owner.

	unique_ptr<Texture> tex2 = move(tex1);
	cout << "tex1 is null: " << (tex1 == nullptr ? "YES" : "NO") << endl;



//=======Part-B : shared_ptr : Shared Shader Ownership=======================

	auto shader = make_shared<Shader>("main_vert", "vertex");
	cout << "Ref count: " << shader.use_count() << endl; //1
	{

		auto rendererRef = shader;
		cout << "Ref count: " << shader.use_count() << endl;  // 2
		auto editorRef   = shader;
		cout << "Ref count: " << shader.use_count() << endl;  // 3
	}

	cout << "Ref count: " << shader.use_count() << endl;   // 1



//=========Part C — weak_ptr : Non-Owning Observer=========================

		auto audio = make_shared<AudioClip>("explosion", 3.5);

		weak_ptr<AudioClip> observer = audio;

		if (auto clip = observer.lock())
		cout << "Clip alive: " << clip->getName() << endl;
		audio.reset();

		// unload
		if (observer.expired())
		cout << "Clip already unloaded." << endl;



	return 0;
}
