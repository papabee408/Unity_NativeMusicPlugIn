using UnityEngine;
using UnityEngine.UI;

public class test_script : MonoBehaviour
{
    public Text text;
    AndroidJavaClass plugin;
    AndroidJavaObject pluginObject;

    string testURL = "";

    private void Start()
    {
        plugin = new AndroidJavaClass("com.example.musicplayer.Musicplayer");
        pluginObject = new AndroidJavaObject("com.example.musicplayer.Musicplayer");
        pluginObject.Call("StreamMedia", testURL);
    }

    private void OnDestroy()
    {
        text.text = pluginObject.Call<string>("onDestroy");
    }

    public void PlayMusic()
    {
        text.text = pluginObject.Call<string>("playAudio", testURL);
    }

    public void PauseMusic()
    {
        text.text = pluginObject.Call<string>("pauseAudio");
    }

    public void RestartMusic()
    {
        text.text = pluginObject.Call<string>("restart");
    }

    public void GetDuration()
    {
        text.text = pluginObject.Call<int>("getDuration").ToString();
    }

    public void GetCurrentPosition()
    {
        text.text = pluginObject.Call<int>("getCurrentPosition").ToString();
    }
}
