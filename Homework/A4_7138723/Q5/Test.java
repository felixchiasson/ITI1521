public class Test {


    public static void main(String[] args) {
        StudentInfo.display();
        BinarySearchTree t = new BinarySearchTree();

        t.add(1);
        t.add(2);
        t.add(3);
        t.add(4);
        t.add(5);
        t.add(6);
        t.add(7);
        t.add(8);

        System.out.println("Ce test devrait donner 4. Résultat: " + t.count(1, 4));
        System.out.println("Ce test devrait donner 3. Résultat: " + t.count(2, 4));
        System.out.println("Ce test devrait donner 0 (bornes qui n'existent pas). Résultat: " + t.count(10, 11));
        System.out.println("Ce test devrait donner 1 (bornes identiques). Résultat: " + t.count(2, 2));
        System.out.println("Ce test devrait donner 3 (bornes superieur non existante). Résultat: " + t.count(6, 10));
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Le prochain test devrait lancer une exception (High < Low)");
        try {
            t.count(7, 2);
            System.out.println("Il n'y a pas eu d'erreur.");
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught");
        }
    }
}
