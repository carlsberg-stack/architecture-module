# architecture-module

architecture-module is a simple library which helps you to follow android mvp and mvvm architecture.

## Installation

Change the project Level build file

```bash
 allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

Change the app Level build file (Add Dependency)

```bash
dependencies {
	        implementation 'com.github.carlsberg-stack:architecture-module:20.5.9'
	}
```
## Use Cases

### Simple
```bash
public class MainActivity extends BaseActivity {
    
    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }
   
   ....
```
### MVP
```bash
public class MainActivity extends MVPActivity<YourLogic> implements YourView {
    
    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }
      
    @Override
    protected YourLogic createPresenter() {
        return new YourPresenter(); // your presenter implementation
    }
    
    YourView implementation
   ....
}

public class YourPresenter extends MVPImpl<YourView> implements YourLogic {
    ....
}
```
### MVVM
```bash
public class MainActivity extends MVVMActivity<YourViewModel>{
    
    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }
      
       @Override
    protected Class<YourViewModel> createViewModelClass() {
        return YourViewModel.class;
    }
   ....
}

public class YourViewModel extends BaseViewModel{
 ...
}
  
```

### For Fragment
```bash
public class MainMainFragment extends MVVMFRAGMENT<youemvvm, your interface if you needed[It has to extend base communicator (You can refer example)]> {

    @Override
    protected int getContentView() {
        return R.layout.fragment_main;
    }

   ....
```


## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.
