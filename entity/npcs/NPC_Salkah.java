package entity.npcs;

import Main.gamePanel;
import entity.Entity; 

public class NPC_Salkah extends Entity {
    
    gamePanel jz; 

    public NPC_Salkah(gamePanel jz) {
        super(jz);
        this.jz = jz; 


        spriteHeight = 128; 
        spriteWidth = 64; 

        entName = "Salkah"; 
        this.portraitFilepath = "/r/resources/portraits/salkahPortrait.png"; 
        
        this.getSprite("/r/resources/sprites/npcs/salkahSprite.png");


        this.setDialogue();
    }

    @Override 
    public void speak() {
        jz.jzUI.currentDialogue = dialogues[dialogueIndex]; 
    }

    @Override
    public void setAction(int speed) {

    }
    
    public void setDialogue() {
        dialogues[0] = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Morbi tristique senectus et netus et. Fringilla urna porttitor rhoncus dolor purus non enim praesent. Magna sit amet purus gravida quis blandit. Amet massa vitae tortor condimentum lacinia quis vel eros. Sem fringilla ut morbi tincidunt augue interdum velit euismod. Amet tellus cras adipiscing enim. A diam maecenas sed enim ut sem viverra. Sit amet commodo nulla facilisi nullam vehicula ipsum a arcu. Ac turpis egestas maecenas pharetra convallis posuere morbi leo. Rutrum quisque non tellus orci ac auctor. Consequat id porta nibh venenatis cras sed. Sit amet mattis vulputate enim nulla. Est pellentesque elit ullamcorper dignissim cras tincidunt lobortis feugiat vivamus. Cursus risus at ultrices mi tempus imperdiet nulla. Iaculis eu non diam phasellus vestibulum lorem. Duis convallis convallis tellus id interdum velit laoreet. Eu sem integer vitae justo eget magna. Feugiat in fermentum posuere urna nec tincidunt praesent. Sit amet cursus sit amet dictum sit amet. Vitae proin sagittis nisl rhoncus mattis.  Non sodales neque sodales ut. Donec ultrices tincidunt arcu non sodales neque sodales ut. At ultrices mi tempus imperdiet nulla malesuada. Auctor urna nunc id cursus metus aliquam eleifend mi in. Purus gravida quis blandit turpis cursus in hac. Id diam maecenas ultricies mi. Pellentesque id nibh tortor id aliquet lectus proin. Pellentesque adipiscing commodo elit at imperdiet dui accumsan sit. Sit amet nisl suscipit adipiscing. Suspendisse ultrices gravida dictum fusce ut placerat orci.  Suspendisse faucibus interdum posuere lorem ipsum dolor sit amet. Tempus urna et pharetra pharetra massa massa ultricies mi. Neque aliquam vestibulum morbi blandit cursus risus at. Quam viverra orci sagittis eu. Neque volutpat ac tincidunt vitae semper quis. Pretium aenean pharetra magna ac. Pellentesque sit amet porttitor eget dolor morbi non arcu. Velit laoreet id donec ultrices tincidunt arcu. Id porta nibh venenatis cras sed. Arcu dictum varius duis at consectetur. Nec ultrices dui sapien eget mi proin sed libero. Posuere morbi leo urna molestie at elementum. Quam id leo in vitae. Sollicitudin tempor id eu nisl nunc. In nisl nisi scelerisque eu. A condimentum vitae sapien pellentesque. Nec nam aliquam sem et tortor consequat id porta. Eu consequat ac felis donec et odio. Placerat in egestas erat imperdiet sed euismod. Scelerisque fermentum dui faucibus in ornare quam viverra. Felis bibendum ut tristique et egestas quis ipsum suspendisse ultrices. Eget sit amet tellus cras adipiscing enim eu. Adipiscing bibendum est ultricies integer quis auctor. Dignissim sodales ut eu sem integer vitae. Orci porta non pulvinar neque laoreet suspendisse interdum consectetur libero. Venenatis tellus in metus vulputate eu scelerisque felis imperdiet. Sit amet nisl suscipit adipiscing bibendum est ultricies integer. Volutpat commodo sed egestas egestas. At tellus at urna condimentum mattis. Mauris pellentesque pulvinar pellentesque habitant morbi tristique senectus. Enim eu turpis egestas pretium aenean pharetra magna ac. A condimentum vitae sapien pellentesque habitant morbi. Libero id faucibus nisl tincidunt eget. Quisque sagittis purus sit amet volutpat consequat mauris nunc congue. Ac feugiat sed lectus vestibulum mattis ullamcorper velit sed ullamcorper. Elit sed vulputate mi sit. Id consectetur purus ut faucibus pulvinar elementum integer enim neque. Enim sit amet venenatis urna cursus. Aliquam ut porttitor leo a diam sollicitudin tempor id. <p>Lorem ipsum dolor sit amet. In voluptatem soluta est maiores enim id sapiente deleniti sed similique minus cum eligendi laudantium nam beatae voluptate. Eos natus nisi sed quam tenetur cum Quis quod ut fuga rerum non praesentium dignissimos sed similique quia. Id nesciunt numquam sit labore maiores quo similique rerum ut quisquam consequatur et laudantium autem aut culpa dolorem ut amet possimus. In voluptatum sunt est rerum tempora et molestias consectetur At laborum nisi quo dolorem quod cum iure atque ut tenetur eligendi. Ut quos delectus ex labore molestias ab omnis magni aut sunt neque. At deserunt facilis aut voluptatem facilis sit labore quos. Et rerum sint qui recusandae omnis est architecto rerum et facilis similique id voluptatem earum qui deserunt fuga sed repellat quisquam. Est dignissimos dolore et possimus iusto ex dolore quasi. Vel totam saepe et ducimus dicta a quaerat quibusdam? Vel repellendus nemo et voluptas veniam ut optio obcaecati et laudantium nihil et nesciunt excepturi qui eius quam qui harum deleniti. Eos voluptates laborum vel incidunt asperiores est quam sunt aut laboriosam dolorem est minima voluptas aut reiciendis Quis qui cumque velit! </p><p>Et dignissimos quisquam est quaerat corporis id repudiandae necessitatibus aut eaque porro. Qui neque officia ut omnis rerum eos quos nesciunt ut saepe labore ut rerum libero eum illum similique. Rem dolorum esse non delectus perferendis 33 magnam natus rem autem quibusdam eum architecto veritatis! Et labore incidunt sed necessitatibus nobis ut voluptatem internos non incidunt dolore. Non repudiandae illum id illo omnis est omnis repellat et aliquam delectus sit illum labore. Nam exercitationem expedita et reprehenderit internos qui obcaecati officia? Ut ducimus minus ab laudantium voluptas est voluptatem accusamus qui quasi corrupti At facilis reiciendis? Aut nisi cupiditate non autem sint At sunt officia et fuga esse aut corporis nemo. Qui itaque porro est deleniti voluptate id laudantium ipsa ea itaque tempora ut dolor inventore At voluptas quia. Ea rerum tempore ut sint deserunt sed molestias nostrum ex corrupti molestias eum fugit velit? Sed architecto explicabo rem provident facilis et quam doloremque ex voluptatem sapiente qui internos molestias. </p><p>Ut dignissimos maxime sit assumenda incidunt 33 amet officiis. Et omnis beatae ut exercitationem molestiae est iusto ipsa. At excepturi odio ea ullam debitis nam nostrum distinctio et debitis modi ea vitae galisum! Sit aliquam maxime rem perferendis voluptatum ut quae quia qui voluptatem velit. Ad inventore consequatur sit sint galisum ex placeat quae et deserunt ullam? Qui impedit culpa ea sint voluptatibus ad voluptatem dolorem in possimus dolore. Ab unde necessitatibus non sunt atque et molestiae culpa sit excepturi nobis! Eos omnis consequatur est mollitia illo ut reprehenderit sint. Ut blanditiis fugiat cum tempora rerum quo repellendus maxime 33 galisum perspiciatis in corporis dolorum ut internos soluta. Qui quam explicabo sed quia voluptate est exercitationem dolorem aut rerum consequatur sit enim autem vel voluptas ullam. Ut omnis officiis in modi maxime aut laudantium nobis et harum error sed autem velit et explicabo possimus sit harum officia.";
        dialogues[1] = "dshkshfks";
        dialogues[2] = "ijafijfe";
        dialogues[3] = "ksdaifhifehe";
    }

    public String getPortraitFilepath() {
        return this.portraitFilepath; 
    }

    public String getName() {
        return this.entName; 
    }
}
