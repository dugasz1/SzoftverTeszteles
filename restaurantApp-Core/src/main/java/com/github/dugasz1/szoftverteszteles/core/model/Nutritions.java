package com.github.dugasz1.szoftverteszteles.core.model;

public class Nutritions {
    private float energy;
    private float fat;
    private float carbohydrate;
    private float protein;
    private float salt;

    /**
     * Creates nutritions object, do not use this use the dao interface.
     * @param energy
     * @param fat
     * @param carbohydrate
     * @param protein
     * @param salt
     */
    public Nutritions(float energy,float fat, float carbohydrate, float protein, float salt) {
        if(energy < 0)
            throw new IllegalArgumentException("Energy cannot be negative.");
        if(fat < 0)
            throw new IllegalArgumentException("Fat cannot be negative");
        if(carbohydrate < 0)
            throw  new IllegalArgumentException("Carbonhydrate cannot be negative");
        if(protein < 0)
            throw new IllegalArgumentException("Protein cannot be negative");
        if(salt < 0)
            throw  new IllegalArgumentException("Salt cannot be negative");
        this.energy = energy;
        this.fat = fat;
        this.carbohydrate = carbohydrate;
        this.protein = protein;
        this.salt = salt;
    }

    public float getCarbohydrate() {
        return carbohydrate;
    }

    public float getEnergy() {
        return energy;
    }

    public float getFat() {
        return fat;
    }

    public float getProtein() {
        return protein;
    }

    public float getSalt() {
        return salt;
    }

    public void setCarbohydrate(float carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public void setEnergy(float energy) {
        this.energy = energy;
    }

    public void setFat(float fat) {
        this.fat = fat;
    }

    public void setProtein(float protein) {
        this.protein = protein;
    }

    public void setSalt(float salt) {
        this.salt = salt;
    }

    @Override
    public  boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        Nutritions nutritions = (Nutritions) obj;
        if(this.energy != nutritions.energy || this.fat != nutritions.fat || this.carbohydrate != nutritions.carbohydrate || this.protein != nutritions.protein || this.salt != nutritions.protein)
            return false;
        return true;
    }
}
