package com.iu.s1.product;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.iu.s1.util.DBConnection;

@Repository
public class ProductDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.s1.product.ProductDAO.";
	
	
	//삭제
	public int setProductDelete(Long productNum) throws Exception {
		
		return sqlSession.delete(NAMESPACE+"setProductDelete", productNum);
	}
	
	
	//----------getProductdetail--------
	
	public ProductDTO getProductdetail(ProductDTO productDTO) throws Exception{
			
		return sqlSession.selectOne(NAMESPACE+"getProductDetail", productDTO);
	}
	
	//---------------------------------- ProductList
	
	public List<ProductDTO> getProductList() throws Exception {
		
		return sqlSession.selectList(NAMESPACE+"getProductList");
	}
	
	//---------------SetAddProduct
	public int setProductAdd(ProductDTO productDTO) throws Exception {
		
		return sqlSession.insert(NAMESPACE+"setAddProduct", productDTO);
		
	}
	
	//---getMax
	public Long getProductNum() throws Exception{
		
		return sqlSession.selectOne(NAMESPACE +"getProductNum");
	
	}
	
	
	
	
	
	//---------------------------ProductOption
	
	public List<ProductOptionDTO> getProductOptionDTOList() throws Exception {
		List<ProductOptionDTO> ar = new ArrayList<ProductOptionDTO>();
		
		Connection con = DBConnection.getConnection();
		
		String sql = "SELECT * FROM PRODUCTOPTION";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			ProductOptionDTO productOptionDTO = new ProductOptionDTO();
			productOptionDTO.setOptionNum(rs.getInt("OPTIONNUM"));
			productOptionDTO.setProductNum(rs.getLong("PRODUCTNUM"));
			productOptionDTO.setOptionName(rs.getString("OPTIONMANE"));
			productOptionDTO.setOptionPrice(rs.getInt("OPTIONPRICE"));
			productOptionDTO.setOptionStock(rs.getInt("OPTIONSTOCK"));
			ar.add(productOptionDTO);
			
		}
		DBConnection.disConnection(st, con, rs);
		
		return ar;
	}
	
	//-------------setAddProductOption
	public int setAddProductOption(ProductOptionDTO productOptionDTO) throws Exception {
		Connection con = DBConnection.getConnection();
		
		String sql ="INSERT INTO PRODUCTOPTION(OPTIONNUM, PRODUCTNUM, OPTIONNAME, OPTIONPRICE OPTIONSTOCK) "
				+ "VALUEX(PRODUCT_SEQ.NEXTVAL, ?, ?, ?, ?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, productOptionDTO.getOptionNum());
		st.setLong(2, productOptionDTO.getProductNum());
		st.setString(3, productOptionDTO.getOptionName());
		st.setInt(4, productOptionDTO.getOptionPrice());
		st.setInt(5, productOptionDTO.getOptionStock());
		
		int result = st.executeUpdate();

		DBConnection.disConnect(st, con);
		
		return result;
		
	}
	
	
	
	
	

	
	
	
	
	

}
