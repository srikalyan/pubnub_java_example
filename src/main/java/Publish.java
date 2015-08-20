import com.pubnub.api.Callback;
import com.pubnub.api.Pubnub;
import com.pubnub.api.PubnubError;

/**
 * @author srikalyan.swayampakula
 */
public class Publish {
   public static void main(String[] args) {
      final Pubnub pubnub = new Pubnub("demo", "demo");
      Callback callback = new Callback() {
         public void successCallback(String channel, Object response) {
            System.out.println(response.toString());
         }
         public void errorCallback(String channel, PubnubError error) {
            System.out.println(error.toString());
         }
      };
      pubnub.publish("my.channel2", "Hey I am here now  2" , callback);
      //pubnub.channelGroupAddChannel("my_channel_group", "my_channel2", callback);
      //pubnub.hereNow("my_channel", callback);

   }
}
