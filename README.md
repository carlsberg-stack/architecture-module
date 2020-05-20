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
	        implementation 'com.github.carlsberg-stack:architecture-module:20.5.22'
	}
```
## Use Cases

### Simple
```bash
public class MainActivity extends CarlsActivity {
    
    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }
    
 public class MainActivity extends CarlsFragmentActivity {
    
    @Override
    protected int carls_getContainerViewId(int id) {
    // when you want to add fragment from from any fragment  then you need to provide container id
        return container_id;
    }
   
    public class MainActivity extends CarlsBroadcastActivity {
    
    @Override
    protected int carls_getContainerViewId(int id) {
    // when you want to add fragment from from any fragment  then you need to provide container id
        return container_id;
    }
    
       @Override
    protected int carls_indexBroadcastReceiver() {
    	you need to index broadcast receiver here. It automatically add register and unregister.
	(like below example CARLS_ON_RESUME - where you want to register CARLS_ON_STOP where you want to unregister)
	                   	 carls_registerBroadcastReceiver(RegisterBroadcastAction.CARLS_ON_RESUME,UnregisterBroadcastAction.CARLS_ON_STOP,
		       broadcastReceiver, new IntentFilter());
    }
   
   ....
```
### MVP
```bash
public class MainActivity extends CarlsMvpActivity<YourLogic> or CarlsMvpFragmentActivity<YourLogic> or CarlsMvpBroadcastActivity<YourLogic> implements YourView {
    
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
public class MainActivity extends CarlsMvvmActivity<YourViewModel> or CarlsMvvmFragmentActivity<YourViewModel> or CarlsMvvmBroadcastActivity<YourViewModel>{
    
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
public class MainMainFragment extends MvvmFragment<youemvvm, your interface if you needed[It has to extend my interface (You can refer example)]> {

    @Override
    protected int getContentView() {
        return R.layout.fragment_main;
    }
    
    public class MainMainFragment extends MvpFragment<youemvvm, your interface if you needed[It has to extend my interface (You can refer example)]> {

    @Override
    protected int getContentView() {
        return R.layout.fragment_main;
    }

   ....
```


## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.
