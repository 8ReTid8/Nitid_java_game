package main;

import entity.Entity;

public class CollisionChecker {

    GamePanel gp;

    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }

    public void checkTile(Entity entity) {

        int entityLeftWorldX = entity.x + entity.solidArea.x;
        int entityRightWorldX = entity.x + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.y + entity.solidArea.y;
        int entityBottomWorldY = entity.y + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX / gp.tilesize;
        int entityRightCol = entityRightWorldX / gp.tilesize;
        int entityTopRow = entityTopWorldY / gp.tilesize;
        int entityBottomRow = entityBottomWorldY / gp.tilesize;

        checkCollisionUp(entityLeftCol, entityRightCol, entityTopWorldY, entity);
        checkCollisionDown(entityLeftCol, entityRightCol, entityBottomWorldY, entity);
        checkCollisionLeft(entityTopRow, entityBottomRow, entityLeftWorldX, entity);
        checkCollisionRight(entityTopRow, entityBottomRow, entityRightWorldX, entity);
    }

    public void checkCollisionUp(int entityLeftCol, int entityRightCol, int entityTopWorldY, Entity entity) {
        int entityTopRow = (entityTopWorldY - entity.speed) / gp.tilesize;
        int tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
        int tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
        entity.isCollisionUp = (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision);
    }

    public void checkCollisionDown(int entityLeftCol, int entityRightCol, int entityBottomWorldY, Entity entity) {
        int entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tilesize;
        int tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
        int tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
        entity.isCollisionDown = (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision);
    }

    public void checkCollisionLeft(int entityTopRow, int entityBottomRow, int entityLeftWorldX, Entity entity) {
        int entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tilesize;
        int tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
        int tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
        entity.isCollisionLeft = (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision);
    }

    public void checkCollisionRight(int entityTopRow, int entityBottomRow, int entityRightWorldX, Entity entity) {
        int entityRightCol = (entityRightWorldX + entity.speed) / gp.tilesize;
        int tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
        int tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
        entity.isCollisionRight = (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision);
    }

    public boolean checkObject(Entity entity, boolean player) {
        if (gp.obj != null) {
            entity.solidArea.x = entity.x + entity.solidArea.x;
            entity.solidArea.y = entity.y + entity.solidArea.y;
            gp.obj.solidArea.x = gp.obj.worldX + gp.obj.solidArea.x;
            gp.obj.solidArea.y = gp.obj.worldY + gp.obj.solidArea.y;

            if (entity.solidArea.intersects(gp.obj.solidArea)) {
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                gp.obj.solidArea.x = gp.obj.solidAreaDefaultX;
                gp.obj.solidArea.y = gp.obj.solidAreaDefaultY;
                return true;
            }
            entity.solidArea.x = entity.solidAreaDefaultX;
            entity.solidArea.y = entity.solidAreaDefaultY;
            gp.obj.solidArea.x = gp.obj.solidAreaDefaultX;
            gp.obj.solidArea.y = gp.obj.solidAreaDefaultY;
        }
        return false;
    }

    public boolean checkEntity(Entity entity, boolean player) {

        entity.solidArea.x = entity.x + entity.solidArea.x;
        entity.solidArea.y = entity.y + entity.solidArea.y;
        gp.player.solidArea.x = gp.player.x + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.y + gp.player.solidArea.y;

        if (entity.solidArea.intersects(gp.player.solidArea)) {
            entity.solidArea.x = entity.solidAreaDefaultX;
            entity.solidArea.y = entity.solidAreaDefaultY;
            gp.player.solidArea.x = gp.player.solidAreaDefaultX;
            gp.player.solidArea.y = gp.player.solidAreaDefaultY;
            return true;
        }
        entity.solidArea.x = entity.solidAreaDefaultX;
        entity.solidArea.y = entity.solidAreaDefaultY;
        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
        return false;
    }
}
