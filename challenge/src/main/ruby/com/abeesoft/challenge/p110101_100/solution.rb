def max_cycle_length first, second
  (first..second).map { |n| cycle_length(n) }.max
end

$_cycleLengths = Hash.new

def cycle_length n
  return $_cycleLengths[n] if $_cycleLengths.key?(n)
  $_cycleLengths[n] = (n > 1) ? 1 + cycle_length(n % 2 == 0 ? n/2 : 3*n+1) : 1
end

if ARGV.length == 2
  f_in = File.open(ARGV[0], 'r')
  f_out = File.open(ARGV[1],'w')
  N = f_in.readline.to_i
  N.times do
    time = Time.now
    array = f_in.readline.split
    next if array.length != 2
    f_out.write "#{array[0]} #{array[1]} #{max_cycle_length(array[0].to_i, array[1].to_i)}\n"
    puts "#{Time.now - time}"
  end
else
  puts "Usage: ruby #{$0} <input_file_path> <output_file_path>"
end

