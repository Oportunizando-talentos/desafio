package br.com.meganews.desafiojunior.desafiojunior.repository;



public class ProdutoZeradoRepository {

    private BancoMobile bancomobile;


    public ProdutoZeradoRepository(Context ctx) {
        //bancomobile = new BancoMobile(ctx);
        bancomobile = BancoMobile.getInstance(ctx);
    }

    public void insertProdutoZerado(ProdutoZerado produtoZerado) {
        SQLiteDatabase db = bancomobile.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("ID_PRODUTO", produtoZerado.getCodigoDeBarra());

        db.insert("TB_PRODUTO_ZERADO", null, cv);
        db.close();
        /*if (id != -1){
            produto.idProduto = id;
        }
        db.close();
        return id;*/
    }



    public void excluirTudoProdutoZerado(ProdutoZerado p) {
        SQLiteDatabase db = bancomobile.getWritableDatabase();
        db.delete("TB_PRODUTO_ZERADO", null, null);
        db.close();

    }

    public List<ProdutoZerado> buscarProdutoZerado() {
        SQLiteDatabase db = bancomobile.getReadableDatabase();
        String sql = "SELECT ID_PRODUTO FROM TB_PRODUTO_ZERADO";
        String[] argumentos = null;
        /*if (filtro != null) {
            sql += " WHERE ID_PRODUTO = '"+filtro+"'";
        }*/
        Cursor cursor = db.rawQuery(sql, null);

        List<ProdutoZerado> prod = new ArrayList<ProdutoZerado>();
        while (cursor.moveToNext()) {

            ProdutoZerado produto = new ProdutoZerado();
            produto.setCodigoDeBarra(cursor.getString(cursor.getColumnIndex("ID_PRODUTO")));
            prod.add(produto);
        }
        cursor.close();
        db.close();
        return prod;
    }

}
