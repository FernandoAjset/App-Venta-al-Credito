/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author fernando
 */
import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;

public class MetodosProducto {

    public static ArrayList<Vector> ConsultarTodo() {
        ArrayList<Vector> listadoProductos = new ArrayList();
        Statement ps = null;
        ResultSet rs;
        try {
            ps = Conexiones.Conexion.getConexion().createStatement();
            rs = ps.executeQuery("select p.cproducto, p.nproducto, s.cantidad_stock, p.pproducto from producto p left join stock s on p.cproducto=s.cproducto");
            while (rs.next()) {
                Vector detalleProducto = new Vector();
                detalleProducto.add(rs.getString(1));
                detalleProducto.add(rs.getString(2));
                detalleProducto.add(rs.getString(3));
                detalleProducto.add(rs.getDouble(4));
                listadoProductos.add(detalleProducto);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return listadoProductos;
    }

    public static int CodigoUltimo() {
        int cnuevo = 0;
        ResultSet rs;
        try {
            Statement mcodigo = Conexiones.Conexion.getConexion().createStatement();
            rs = mcodigo.executeQuery("select cproducto from producto");
            while (rs.next()) {
                String cproducto = rs.getString("CPRODUCTO");
                if (Integer.parseInt(cproducto) > cnuevo) {
                    cnuevo = Integer.parseInt(cproducto);
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());

        }
        return cnuevo;
    }

    public static int CantidadStock(int id) {
        int cstock = 0;
        ResultSet rs;
        try {
            Statement mcodigo = Conexiones.Conexion.getConexion().createStatement();
            rs = mcodigo.executeQuery("select cproducto, cantidad_stock from stock");
            while (rs.next()) {
                String cproducto = rs.getString("CPRODUCTO");
                String stock = rs.getString("CANTIDAD_STOCK");
                if (id == Integer.parseInt(cproducto)) {
                    cstock = Integer.parseInt(stock);
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());

        }
        return cstock;
    }

    public static boolean ExisteCodigoStock(int id) {
        int aux;
        boolean r = false;
        ResultSet rs;
        try {
            Statement mcodigo = Conexiones.Conexion.getConexion().createStatement();
            rs = mcodigo.executeQuery("select cproducto from stock");
            while (rs.next()) {
                String cproducto = rs.getString("CPRODUCTO");
                aux = Integer.parseInt(cproducto);
                if (id == aux) {
                    r = true;
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());

        }
        return r;
    }

    public static String MostrarProducto(int id) {
        Statement ps = null;
        ResultSet rs;
        String Info = new String();
        try {
            ps = Conexiones.Conexion.getConexion().createStatement();
            rs = ps.executeQuery("select cproducto, nproducto from producto");
            while (rs.next()) {
                String cproducto = rs.getString("CPRODUCTO");
                int aux = Integer.parseInt(cproducto);

                String nombre = rs.getString("NPRODUCTO");
                if (id == aux) {
                    return nombre;
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());

        }
        return null;
    }

    public static String MostrarPrecioProducto(int id) {
        Statement ps = null;
        ResultSet rs;
        String Info = new String();
        try {
            ps = Conexiones.Conexion.getConexion().createStatement();
            rs = ps.executeQuery("select cproducto, pproducto from producto");
            while (rs.next()) {
                String cproducto = rs.getString("CPRODUCTO");
                int aux = Integer.parseInt(cproducto);
                String precio = new String();//="Q.";
                precio += rs.getString("PPRODUCTO");
                if (id == aux) {
                    return precio;
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());

        }
        return null;
    }

    public static void GrabarNuevoProducto(Producto nuevoProducto) {
        try {
            PreparedStatement ps2 = Conexiones.Conexion.getConexion().prepareStatement("insert into producto values (?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            //REDONDEAR PRECIO ANTES DE INGRESAR A BD
            DecimalFormat formato = new DecimalFormat("#.00");
            int r = (int) Math.round(nuevoProducto.precioProducto * 100);
            nuevoProducto.precioProducto = r / 100.0;
            ps2.setInt(1, nuevoProducto.codigoProducto);
            ps2.setString(2, nuevoProducto.nombreProducto);
            ps2.setDouble(3, nuevoProducto.precioProducto);
            ps2.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo grabar datos " + e.getMessage(),
                    "Error de Escritura", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void GrabarStockInicial(Producto nuevoProducto, int cantidadInicial) {
        try {
            PreparedStatement ps2 = Conexiones.Conexion.getConexion().prepareStatement("insert into stock values (?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            ps2.setInt(1, nuevoProducto.codigoProducto);
            ps2.setDouble(2, cantidadInicial);
            ps2.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo grabar datos " + e.getMessage(),
                    "Error de Escritura", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void ingresoStock(int idproducto, int cantidad) {
        try {
            int Stock = MetodosProducto.CantidadStock(idproducto);
            int ExistenciaNueva = Stock + cantidad;
            PreparedStatement pps = Conexiones.Conexion.getConexion().prepareStatement("update stock set cantidad_stock='"
                    + ExistenciaNueva + "' where cproducto='" + idproducto + "'");
            pps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "La BD tiene problemas" + e.getMessage(),
                    "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void salidaStock(int idProducto) {
        try {
            int Stock = MetodosProducto.CantidadStock(idProducto);
            int ExistenciaNueva = Stock - 1;
            System.out.println("ExistenciaNueva = " + ExistenciaNueva);
            PreparedStatement pps = Conexiones.Conexion.getConexion().prepareStatement("update stock set cantidad_stock='"
                    + ExistenciaNueva + "' where cproducto='" + idProducto + "'");
            pps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "La BD tiene problemas" + e.getMessage(),
                    "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static boolean EditarProducto(Producto productoEditado, int stock) {
        try {
            PreparedStatement pps = Conexiones.Conexion.getConexion().prepareStatement("update producto set nproducto='"
                    + productoEditado.getNombreProducto() + "', pproducto='" + productoEditado.getPrecioProducto() + "' where cproducto='" + productoEditado.getCodigoProducto() + "'");
            pps.executeUpdate();
            EditarStock(productoEditado, stock);
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "La BD tiene problemas" + e.getMessage(),
                    "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(System.out);
            return false;
        }
    }

    public static boolean EditarStock(Producto productoEditado, int stock) {
        try {
            PreparedStatement pps = Conexiones.Conexion.getConexion().prepareStatement("update stock set cantidad_stock='"
                    + stock + "' where cproducto='" + productoEditado.getCodigoProducto() + "'");
            pps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "La BD tiene problemas" + e.getMessage(),
                    "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(System.out);
            return false;
        }
    }

    public static boolean eliminarProducto(Producto productoEliminado) {
        try {
            PreparedStatement pps = Conexiones.Conexion.getConexion().prepareStatement("DELETE FROM producto where cproducto='" + productoEliminado.getCodigoProducto() + "' AND ROWNUM=1");
            pps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "La BD tiene problemas" + e.getMessage(),
                    "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(System.out);
            return false;
        }
    }
    
        public static boolean eliminarStock(Producto productoEliminado) {
        try {
            PreparedStatement pps = Conexiones.Conexion.getConexion().prepareStatement("DELETE FROM stock where cproducto='" + productoEliminado.getCodigoProducto() + "' AND ROWNUM=1");
            pps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "La BD tiene problemas" + e.getMessage(),
                    "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(System.out);
            return false;
        }
    }
}
